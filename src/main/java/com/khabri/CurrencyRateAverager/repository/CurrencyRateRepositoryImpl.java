package com.khabri.CurrencyRateAverager.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.khabri.CurrencyRateAverager.model.ExchgRateResponse;

@Repository
public class CurrencyRateRepositoryImpl implements CurrencyRateRepository {

	private String urlTemplate;
	
	public CurrencyRateRepositoryImpl(@Value("${exchange.rate.url.template}") String urlTemplate) {
		this.urlTemplate = urlTemplate;
	}

//	@Cacheable(cacheNames = "APIData")
	public ExchgRateResponse getRatesFromAPICall(String start_at, String end_at, String base) {
		System.out.println(urlTemplate);
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("start_at", start_at);
		uriVariables.put("end_at", end_at);
		uriVariables.put("base", base);
		
		RestTemplate restTemplate = new RestTemplate();
		ExchgRateResponse obj = restTemplate.getForEntity(urlTemplate, ExchgRateResponse.class, uriVariables).getBody();
		System.out.println(obj);
		
		return obj;
	
	}
}
