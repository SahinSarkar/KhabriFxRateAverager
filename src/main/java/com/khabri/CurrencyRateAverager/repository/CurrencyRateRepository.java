package com.khabri.CurrencyRateAverager.repository;

import com.khabri.CurrencyRateAverager.model.ExchgRateResponse;

public interface CurrencyRateRepository {

	public ExchgRateResponse getRatesFromAPICall(String start_at, String end_at, String base);
}
