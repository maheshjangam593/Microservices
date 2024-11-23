package com.example.demo;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyConversionProxy proxy;

	@GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	// @CircuitBreaker(name = "default", fallbackMethod = "hardcodedValues")
	
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		HashMap<String, String> uriVariables = new HashMap<>();

		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> response = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);

		CurrencyConversion currencyConversion = response.getBody();

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());
	}

	
	@GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedValues")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity, Exception ex) {

		/*
		 * HashMap<String, String> uriVariables = new HashMap<>();
		 * 
		 * uriVariables.put("from", from); uriVariables.put("to", to);
		 * ResponseEntity<CurrencyConversion> response = new
		 * RestTemplate().getForEntity(
		 * "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
		 * CurrencyConversion.class, uriVariables);
		 */
		CurrencyConversion currencyConversion = proxy.retriveExchange(from, to);

		return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
				currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment());
	}

	/*
	 * public String hardcodedValues(@PathVariable String from, @PathVariable String
	 * to, @PathVariable BigDecimal quantity, Exception ex) { return
	 * "defalut fallback method"; }
	 */
	public CurrencyConversion hardcodedValues(String USR, String INR, BigDecimal quantity) {
		return new CurrencyConversion(1001L, USR, INR, BigDecimal.valueOf(65), BigDecimal.valueOf(1000),
				BigDecimal.valueOf(65000), "8000");
	}
}
