package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfigurations() {
		return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());

	}

	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallBackretriveLimitsFromConfigurations")
	public LimitConfiguration retriveLimitsConfigurations() {
		throw new RuntimeException("not valid");
	}

	@GetMapping("/limits")
	public LimitConfiguration fallBackretriveLimitsFromConfigurations() {
		return new LimitConfiguration(1, 11);

	}

}
