package com.khabri.CurrencyRateAverager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.khabri.CurrencyRateAverager.model.AverageRateResponse;
import com.khabri.CurrencyRateAverager.service.CurrencyRateAveragerService;

@RestController("/")
public class CurrencyAveragerController {
	
	@Autowired
	private CurrencyRateAveragerService currencyRateAveragerService;

	@RequestMapping(method = RequestMethod.GET)
	public AverageRateResponse getAverageRatesForCurrencies(String start_at, String end_at, String base, String symbols) {
		AverageRateResponse result = currencyRateAveragerService.getAverageExchangeRatesForCurrencies(start_at, end_at, base, symbols);
		return result;
	}
}
