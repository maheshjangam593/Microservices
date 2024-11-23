package com.example.demo.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	public DaoService service;

	@RequestMapping("/users")
	public List<User> retriveAll() {
		return service.FindAll();
	}

	@GetMapping("/users/{id}")
	public EntityModel<User> findOne(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id " + id);
		}

		EntityModel<User> model = EntityModel.of(user);

		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAll());
		model.add(linkToUsers.withRel("all-users"));
		return model;

	}

	@DeleteMapping("/users/{id}")
	public User deleteUser(@PathVariable int id) {
		User user = service.deleteUser(id);
		if (user == null) {
			throw new UserNotFoundException("id " + id);
		}
		return user;
	}

	/*
	 * @PostMapping("/users") public User Adduser(@RequestBody User user) { return
	 * service.Save(user); }
	 */
	@PostMapping("/users")
	public ResponseEntity<Object> Adduser(@Valid @RequestBody User user) {
		User savedUser = service.Save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
