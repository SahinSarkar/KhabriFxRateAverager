package com.khabri.CurrencyRateAverager.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.khabri.CurrencyRateAverager.model.AverageRateResponse;

@Service
public class CurrencyRateAveragerService {

	@Autowired
	CacheManager cacheManager;
	private static final String urlTemplate = "https://api.exchangeratesapi.io/history?start_at={start_at}&end_at={end_at}&symbols={symbols}&base={base}";

	@Cacheable
	public AverageRateResponse getAverageExchangeRatesForCurrencies(String start_at, String end_at, String base, String symbols) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("start_at", start_at);
		uriVariables.put("end_at", end_at);
		uriVariables.put("base", base);
		uriVariables.put("symbols", symbols);
		
		RestTemplate restTemplate = new RestTemplate();
		AverageRateResponse obj = restTemplate.getForEntity(urlTemplate, AverageRateResponse.class, uriVariables).getBody();
		System.out.println(obj);
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
	
	private AverageRateResponse returnProcessedResponse(AverageRateResponse unprocessedResponse) {
		int numOfDays = unprocessedResponse.getAvgCurrencyExchangeRates().keySet().size();
		Set<String> currencies = unprocessedResponse.getAvgCurrencyExchangeRates().entrySet().iterator().next().getValue().keySet();
		
		Map<String, Integer> currencyExchgRate = new HashMap<>();
		
		
		return null;
	}
	
	public static void main(String[] args) {
		new CurrencyRateAveragerService().getAverageExchangeRatesForCurrencies("2018-01-01", "2018-09-01", "USD", "ILS,JPY");
	}
}
