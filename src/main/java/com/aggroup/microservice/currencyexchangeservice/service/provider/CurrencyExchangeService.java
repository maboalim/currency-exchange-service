package com.aggroup.microservice.currencyexchangeservice.service.provider;

import com.aggroup.microservice.currencyexchangeservice.bean.ExchangeValue;

public interface CurrencyExchangeService {
	public ExchangeValue getCurrencyExchangeRate(String fromCurrency, String toCurrency);
}
