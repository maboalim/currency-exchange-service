package com.aggroup.microservice.currencyexchangeservice.bean;

import java.math.BigDecimal;

/**
 * Exchange Value bean which will be returned for exchange rate API
 * 
 * @author Mina
 *
 */
public class ExchangeValue {

	private String fromCurrency;
	private String toCurrency;
	private BigDecimal rate;

	public ExchangeValue() {

	}

	public ExchangeValue(String fromCurrency, String toCurrency, BigDecimal rate) {
		super();
		this.fromCurrency = fromCurrency;
		this.toCurrency = toCurrency;
		this.rate = rate;
	}

	public String getFromCurrency() {
		return fromCurrency;
	}

	public void setFromCurrency(String fromCurrency) {
		this.fromCurrency = fromCurrency;
	}

	public String getToCurrency() {
		return toCurrency;
	}

	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "ExchangeValue [fromCurrency=" + fromCurrency + ", toCurrency=" + toCurrency + ", rate=" + rate + "]";
	}

}
