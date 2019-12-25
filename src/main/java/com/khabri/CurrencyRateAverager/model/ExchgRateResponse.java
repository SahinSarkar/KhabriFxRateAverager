package com.khabri.CurrencyRateAverager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

//@RedisHash
public class ExchgRateResponse implements Serializable {

	private static final long serialVersionUID = -2898232681655545927L;
	private Date startDate;
	private Date endDate;
	private String baseCurrency;
	private Map<String, Map<String, Double>> avgCurrencyExchangeRates;

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
	public Map<String, Map<String, Double>> getAvgCurrencyExchangeRates() {
		return avgCurrencyExchangeRates;
	}

	public void setAvgCurrencyExchangeRates(Map<String, Map<String, Double>> avgCurrencyExchangeRates) {
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
		return "ExchgRateResponse [startDate=" + startDate + ", endDate=" + endDate + ", baseCurrency=" + baseCurrency
				+ ", avgCurrencyExchangeRates=" + avgCurrencyExchangeRates + "]";
	}

}
