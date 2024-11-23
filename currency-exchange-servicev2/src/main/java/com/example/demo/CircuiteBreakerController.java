package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuiteBreakerController {

	private Logger logger = LoggerFactory.getLogger(CircuiteBreakerController.class);

	@GetMapping("/sample-api")
//	@Retry(name = "sample-api", fallbackMethod = "hardcodedValues")
	 @CircuitBreaker(name = "default", fallbackMethod = "hardcodedValues")
	// @RateLimiter(name = "default")
	//@Bulkhead(name = "default")
	public String sample() {

		/*
		 * logger.info("Sample API recived"); ResponseEntity<String> restTemplate = new
		 * RestTemplate().getForEntity("http:localhost:8800/dummy-uri", String.class);
		 * 
		 * return restTemplate.getBody();
		 */
		return "sample API";
	}

	public String hardcodedValues(Exception ex) {
		return "defalut fallback method";
	}
}
