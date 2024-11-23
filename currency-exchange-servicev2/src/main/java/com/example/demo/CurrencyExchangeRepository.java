package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchangeRepository findByFromAndTo(String from, String to);

}
