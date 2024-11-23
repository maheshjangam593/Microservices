package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange-servicev2",url="localhost:8000")
@FeignClient(name="currency-exchange-servicev2")
public interface CurrencyConversionProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")	
	public CurrencyConversion retriveExchange(@PathVariable String from, @PathVariable String to) ;			
}