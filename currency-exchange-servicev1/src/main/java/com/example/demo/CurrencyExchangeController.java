package com.example.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ExchangeRepository repository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchange = new ExchangeValue(1L, from, to, BigDecimal.valueOf(65));
		
		logger.info("{}",exchange);
		
		exchange.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchange;
	}
}
