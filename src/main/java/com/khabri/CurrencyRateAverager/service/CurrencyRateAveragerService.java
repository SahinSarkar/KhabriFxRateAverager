package com.khabri.CurrencyRateAverager.service;

import com.khabri.CurrencyRateAverager.model.AverageCurrencyExchgRate;

public interface CurrencyRateAveragerService {

	public AverageCurrencyExchgRate getAverageExchangeRatesForCurrencies(String start_at, String end_at, String base,
			String symbols);
}
