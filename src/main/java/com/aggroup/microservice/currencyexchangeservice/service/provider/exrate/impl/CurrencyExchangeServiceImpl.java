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
import com.aggroup.microservice.currencyexchangeservice.service.provider.exrate.proxy.CurrencyExchangeFeignProxy;

@Service
@Qualifier("ExchangeServiceRate")
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	Configuration configuration;
	
	@Autowired
	private CurrencyExchangeFeignProxy proxy;

	/**
	 * This is the old way to call external APIs with rest template but in microservice app, it should be feign integrated with ribbon and naming server
	 * @param fromCurrency
	 * @param toCurrency
	 * @return
	 */
	@SuppressWarnings("unused")
	private ExchangeRate getOneCurrencyExchangeRateByRestTemplate(String fromCurrency, String toCurrency) {
		RestTemplate restTemplate = new RestTemplate();
		Map<String, String> vars = new HashMap<>();
		vars.put("base", fromCurrency.toUpperCase());
		vars.put("symbols", toCurrency.toUpperCase());
		return restTemplate.getForObject(configuration.getApiURL(), ExchangeRate.class, vars);
	}
	
	/**
	 * Retrieve exchange information using feign proxy
	 * @param fromCurrency
	 * @param toCurrency
	 * @return
	 */
	private ExchangeRate getOneCurrencyExchangeRateByFeignProxy(String fromCurrency, String toCurrency) {
		return proxy.retrieveExchangeValue(fromCurrency.toUpperCase(), toCurrency.toUpperCase());
	}

	/**
	 * Get currency exchange rate
	 */
	public ExchangeValue getCurrencyExchangeRate(String fromCurrency, String toCurrency) {
		ExchangeRate exchangeRate = getOneCurrencyExchangeRateByFeignProxy(fromCurrency, toCurrency);
		return new ExchangeValue(fromCurrency, toCurrency, exchangeRate.getRates().get(toCurrency.toUpperCase()));
	}
}
