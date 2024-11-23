package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class LimitConfiguration {

	private int maximum;
	private int minimum;
	
	public LimitConfiguration() {
		super();
	}

	public LimitConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	@Override
	public String toString() {
		return "LimitConfiguration [maximum=" + maximum + ", minimum=" + minimum + "]";
	}
	
	
}
