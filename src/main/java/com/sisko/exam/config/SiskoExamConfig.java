package com.sisko.exam.config;

import com.sisko.exam.conversion.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiskoExamConfig {

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }
}
