package com.sisko.exam.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sisko.exam.app.conversion.DateFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SiskoExamConfig {
    @Value("${spring.application.back-end-url}")
    private String baseUrl;

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public String backEndUrl() {
        return baseUrl;
    }
}
