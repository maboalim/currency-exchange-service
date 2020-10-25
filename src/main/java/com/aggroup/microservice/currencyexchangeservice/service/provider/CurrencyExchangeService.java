package com.aggroup.microservice.currencyexchangeservice.service.provider;

import com.aggroup.microservice.currencyexchangeservice.bean.ExchangeValue;

/*
 * This interface represent the signature for any implementation for get currency exchange rate
 */
public interface CurrencyExchangeService {
	public ExchangeValue getCurrencyExchangeRate(String fromCurrency, String toCurrency);
}
