package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	public Environment environment;

	@Autowired
	public CurrencyExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retriveExchange(@PathVariable String from, @PathVariable String to) {
		
		  CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to,
		  BigDecimal.valueOf(55));
		 
		//CurrencyExchange currencyExchange = (CurrencyExchange) repository.findByFromAndTo(from, to);
		if (currencyExchange == null) {
			throw new RuntimeException("not found from " + from + " to " + to);
		}

		String port = environment.getProperty("local.server.port");

		currencyExchange.setEnvironment(port);

		return currencyExchange;
	}
}
