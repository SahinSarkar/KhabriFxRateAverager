package com.khabri.CurrencyRateAverager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CurrencyRateAveragerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyRateAveragerApplication.class, args);
	}

}
