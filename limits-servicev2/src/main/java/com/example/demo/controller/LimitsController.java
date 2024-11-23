package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Limit;
import com.example.demo.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limit retrievLimits() {
		return new Limit(configuration.getMinimum(), configuration.getMaximum());
	}

}
