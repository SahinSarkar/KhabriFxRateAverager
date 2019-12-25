package com.khabri.CurrencyRateAverager.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khabri.CurrencyRateAverager.model.AverageCurrencyExchgRate;
import com.khabri.CurrencyRateAverager.model.ExchgRateResponse;
import com.khabri.CurrencyRateAverager.repository.CurrencyRateRepository;

@Service
public class CurrencyRateAveragerServiceImpl implements CurrencyRateAveragerService {

	private CurrencyRateRepository currencyRateGetter;

	@Autowired
	public CurrencyRateAveragerServiceImpl(CurrencyRateRepository currencyRateGetter) {
		this.currencyRateGetter = currencyRateGetter;
	}

//	@Cacheable(cacheNames = "ServiceData")
	public AverageCurrencyExchgRate getAverageExchangeRatesForCurrencies(String start_at, String end_at, String base,
			String symbols) {
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = new SimpleDateFormat("yyyy-MM-dd").parse(start_at);
			endDate = new SimpleDateFormat("yyyy-MM-dd").parse(end_at);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(startDate.before(new Date(2000, 01, 01)) || endDate.after(new Date())){
			return null;
		}

		ExchgRateResponse response = currencyRateGetter.getRatesFromAPICall(start_at, end_at, base);
		Map<String, Double> avgFxRates = returnProcessedResponse(response, symbols);

		AverageCurrencyExchgRate avgExchgRateForCurrencies = new AverageCurrencyExchgRate();
		avgExchgRateForCurrencies.setStartDate(start_at);
		avgExchgRateForCurrencies.setEndDate(end_at);
		avgExchgRateForCurrencies.setCurrency(response.getBaseCurrency());
		avgExchgRateForCurrencies.setAvgExchangeRate(avgFxRates);

		return avgExchgRateForCurrencies;
	}

	Map<String, Double> returnProcessedResponse(ExchgRateResponse unprocessedResponse, String symbols) {
		String[] fxRateSymbols = symbols.split(",");

		Map<String, Double> currencyExchgRate = new HashMap<>();
		for (String currency : fxRateSymbols) {
			currencyExchgRate.put(currency, 0.0);
		}

		Collection<Map<String, Double>> valuesFromAPIResponse = unprocessedResponse.getAvgCurrencyExchangeRates()
				.values();
		Iterator<Map<String, Double>> it = valuesFromAPIResponse.iterator();
		for (int i = 1; i < valuesFromAPIResponse.size(); i++) {
			Map<String, Double> mapOfFxRateForOneDay = it.next();
			for (String curr : currencyExchgRate.keySet()) {
				Double fxRateForSingleCurrency = currencyExchgRate.get(curr);
				double currentAvg = ((fxRateForSingleCurrency * (i - 1) + mapOfFxRateForOneDay.get(curr)) / i);
				currencyExchgRate.put(curr, currentAvg);
			}
		}

		return currencyExchgRate;
	}

}
