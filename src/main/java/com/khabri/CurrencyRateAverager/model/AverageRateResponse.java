package com.khabri.CurrencyRateAverager.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageRateResponse {

	private Date startDate;
	private Date endDate;
	private String baseCurrency;
	private Map<String, Map<String, Integer>> avgCurrencyExchangeRates;

	@JsonProperty("start_at")
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@JsonProperty("end_at")
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@JsonProperty("rates")
	public Map<String, Map<String, Integer>> getAvgCurrencyExchangeRates() {
		return avgCurrencyExchangeRates;
	}

	public void setAvgCurrencyExchangeRates(Map<String, Map<String, Integer>> avgCurrencyExchangeRates) {
		this.avgCurrencyExchangeRates = avgCurrencyExchangeRates;
	}

	@JsonProperty("base")
	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	@Override
	public String toString() {
		return "AverageRateResponse [startDate=" + startDate + ", endDate=" + endDate + ", baseCurrency=" + baseCurrency
				+ ", avgCurrencyExchangeRates=" + avgCurrencyExchangeRates + "]";
	}

}
