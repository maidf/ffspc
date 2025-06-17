package com.maidf.service_order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import feign.Logger.Level;

@Configuration
public class OrderConfig {
    
    @Bean
    Level feighLoggerLevel() {
        return Level.FULL;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
