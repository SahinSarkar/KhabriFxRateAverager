package com.khabri.CurrencyRateAverager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;

@SpringBootApplication
@EnableCaching
public class CurrencyRateAveragerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyRateAveragerApplication.class, args);
	}
	
//	@Bean
//    @Primary
//    public CacheManager guavaCacheManager() {
//        RedisCacheManager gcm = new RedisCacheManager();
//        return gcm;
//    }

}
