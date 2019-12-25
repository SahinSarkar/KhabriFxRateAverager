package com.khabri.CurrencyRateAverager.model;

public class AverageCurrencyExchgRate {

	private String currency;
	private double avgExchangeRate;
	public AverageCurrencyExchgRate(String currency, double avgExchangeRate) {
		super();
		this.currency = currency;
		this.avgExchangeRate = avgExchangeRate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAvgExchangeRate() {
		return avgExchangeRate;
	}
	public void setAvgExchangeRate(double avgExchangeRate) {
		this.avgExchangeRate = avgExchangeRate;
	}
	
	
	
}
