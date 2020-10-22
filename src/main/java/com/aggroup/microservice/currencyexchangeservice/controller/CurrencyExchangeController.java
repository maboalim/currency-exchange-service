package com.aggroup.microservice.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aggroup.microservice.currencyexchangeservice.bean.ExchangeValue;
import com.aggroup.microservice.currencyexchangeservice.service.provider.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {

	@Autowired
	@Qualifier("ExchangeServiceRate")
	CurrencyExchangeService CurrencyExchangeService;

	@GetMapping("currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		return CurrencyExchangeService.getCurrencyExchangeRate(fromCurrency, toCurrency);
	}
}
