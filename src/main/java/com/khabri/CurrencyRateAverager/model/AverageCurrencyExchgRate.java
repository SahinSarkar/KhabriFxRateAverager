package com.khabri.CurrencyRateAverager.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AverageCurrencyExchgRate implements Serializable {

	private static final long serialVersionUID = 3176812772221689913L;

	private String currency;
	
	private String startDate;
	
	private String endDate;
	
	private Map<String, Double> avgExchangeRate;

	@JsonProperty("baseCurrency")
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	@JsonProperty("averageExchangeRates")
	public Map<String, Double> getAvgExchangeRate() {
		return avgExchangeRate;
	}
	public void setAvgExchangeRate(Map<String, Double> avgExchangeRate) {
		this.avgExchangeRate = avgExchangeRate;
	}
	
	@JsonProperty("startDate")
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@JsonProperty("endDate")
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "AverageCurrencyExchgRate [currency=" + currency + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", avgExchangeRate=" + avgExchangeRate + "]";
	}
	
}
