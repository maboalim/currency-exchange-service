package com.aggroup.microservice.currencyexchangeservice.service.provider.exrate.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aggroup.microservice.currencyexchangeservice.Configuration;
import com.aggroup.microservice.currencyexchangeservice.bean.ExchangeRate;
import com.aggroup.microservice.currencyexchangeservice.bean.ExchangeValue;
import com.aggroup.microservice.currencyexchangeservice.service.provider.CurrencyExchangeService;

@Service
@Qualifier("ExchangeServiceRate")
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	Configuration configuration;

	private ExchangeRate getAllCurrencyExchangeRates() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(configuration.getApiURL(), ExchangeRate.class, "", "");
	}

	private ExchangeRate getOneCurrencyExchangeRate(String fromCurrency, String toCurrency) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<>();
		vars.put("base", fromCurrency.toUpperCase());
		vars.put("symbols", toCurrency.toUpperCase());
		return restTemplate.getForObject(configuration.getApiURL(), ExchangeRate.class, vars);
	}

	public ExchangeValue getCurrencyExchangeRate(String fromCurrency, String toCurrency) {
		ExchangeRate exchangeRate = getOneCurrencyExchangeRate(fromCurrency, toCurrency);
		return new ExchangeValue(fromCurrency, toCurrency, exchangeRate.getRates().get(toCurrency.toUpperCase()));
	}
}
