package com.example.demo.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
public class UserJPAResource {

	@Autowired
	private UserJPARepository userRepository;
	@Autowired
	private PostJPARepository postRepository;

	@RequestMapping("/jpa/users")
	public List<User> retriveAll() {
		return userRepository.findAll();
	}

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> findOne(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id " + id);
		}

		EntityModel<User> model = EntityModel.of(user.get());

		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retriveAll());
		model.add(linkToUsers.withRel("all-users"));
		return model;

	}

	@DeleteMapping("jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	/*
	 * @PostMapping("/users") public User Adduser(@RequestBody User user) { return
	 * service.Save(user); }
	 */
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> Adduser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	// oneToMany to get post of a user
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retriveAll(@PathVariable int id) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id " + id);
		}
		return userOptional.get().getPost();
	}
	//posting a post for a user
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id " + id);
		}
		User user=userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

}
