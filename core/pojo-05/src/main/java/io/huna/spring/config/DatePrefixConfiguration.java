package io.huna.spring.config;

import io.huna.spring.sequence.DatePrefixGenerator;
import io.huna.spring.sequence.PrefixGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatePrefixConfiguration {

    @Bean
    public PrefixGenerator datePrefixGenerator() {
        DatePrefixGenerator generator = new DatePrefixGenerator();
        generator.setPattern("yyyyMMdd");
        return generator;
    }
}
