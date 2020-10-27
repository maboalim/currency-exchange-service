package com.aggroup.microservice.currencyexchangeservice.service.provider.exrate.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aggroup.microservice.currencyexchangeservice.bean.ExchangeRate;

/**
 * This interface used to call the external API using feign client
 * 
 * @author Mina
 *
 */
@FeignClient(value = "currency-exchange-exrate", url = "https://api.exchangeratesapi.io")
public interface CurrencyExchangeFeignProxy {
	@GetMapping("/latest")
	public ExchangeRate retrieveExchangeValue(@RequestParam(value = "base") String base,
			@RequestParam(value = "symbols") String symbols);
}
