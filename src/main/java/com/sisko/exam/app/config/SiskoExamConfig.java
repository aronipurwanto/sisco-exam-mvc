package com.sisko.exam.app.config;

import com.sisko.exam.app.conversion.DateFormatter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SiskoExamConfig {

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }
}
