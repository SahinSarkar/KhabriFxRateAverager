package com.khabri.CurrencyRateAverager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khabri.CurrencyRateAverager.model.AverageCurrencyExchgRate;
import com.khabri.CurrencyRateAverager.service.CurrencyRateAveragerService;

@RestController
@RequestMapping("/averageExchangeRates")
public class CurrencyAveragerController {

	private CurrencyRateAveragerService currencyRateAveragerService;

	@Autowired
	public CurrencyAveragerController(CurrencyRateAveragerService currencyRateAveragerService) {
		this.currencyRateAveragerService = currencyRateAveragerService;
	}

	@GetMapping
	public AverageCurrencyExchgRate getAverageRatesForCurrencies(String start_at, String end_at, String base,
			String symbols) {
		AverageCurrencyExchgRate result = currencyRateAveragerService.getAverageExchangeRatesForCurrencies(start_at,
				end_at, base, symbols);
		return result;
	}
}
