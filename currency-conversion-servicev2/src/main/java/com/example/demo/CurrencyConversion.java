package com.example.demo;

import java.math.BigDecimal;

public class CurrencyConversion {

	private Long id;
//	@Column(name="currency_from")
	private String from;
//	@Column(name="currency_to")
	private String to;
	private BigDecimal quantiy;
	private BigDecimal conversionMultiple;
	
	private BigDecimal totalCalculatedAmount;
	private String environment;

	public CurrencyConversion() {

	}

	public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantiy,
			BigDecimal totalCalculatedAmount, String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantiy = quantiy;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}

	public BigDecimal getQuantiy() {
		return quantiy;
	}

	public void setQuantiy(BigDecimal quantiy) {
		this.quantiy = quantiy;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
