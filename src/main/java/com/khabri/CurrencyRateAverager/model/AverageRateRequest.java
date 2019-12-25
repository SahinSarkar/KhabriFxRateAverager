package com.khabri.CurrencyRateAverager.model;

import java.util.Date;
import java.util.List;

public class AverageRateRequest {

	private Date startDate;
	private Date endDate;
	
	private String baseCurrency;
	
	public AverageRateRequest(Date startDate, Date endDate, String baseCurrency, List<String> currencies) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.baseCurrency = baseCurrency;
		this.requiredCurrencies = currencies;
	}

	private List<String> requiredCurrencies;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<String> getCurrencies() {
		return requiredCurrencies;
	}

	public void setCurrencies(List<String> currencies) {
		this.requiredCurrencies = currencies;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	
	
}
