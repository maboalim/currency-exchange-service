package com.aggroup.microservice.currencyexchangeservice.bean;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Exchange rate bean as what will be received from Currency Exchange Provider
 * 
 * @author Mina
 *
 */
public class ExchangeRate {
	private Map<String, BigDecimal> rates;
	private String base;
	private String date;

	public ExchangeRate() {

	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public void setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
	}

	public String getBase() {
		return base;
	}

	public void setBase(String base) {
		this.base = base;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
