package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

	@GetMapping("P1")
	public Person1 person1() {
		return new Person1("Jangam mahesh");
	}

	@GetMapping("P2")
	public Person2 person2() {
		return new Person2(new Name("jangam", "mahesh"));
	}

}
