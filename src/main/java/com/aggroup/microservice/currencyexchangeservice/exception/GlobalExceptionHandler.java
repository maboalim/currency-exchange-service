package com.aggroup.microservice.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	ResponseEntity<String> onOtherException(Exception exception) {
		return new ResponseEntity<>("Unsupported currency, you can use USD, EUR, ZAR, CAD, CHF, GBP, JPY", HttpStatus.BAD_REQUEST);
	}
}
