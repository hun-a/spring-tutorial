package io.huna.spring.config;

import io.huna.spring.calculator.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("io.huna.spring")
public class CalculatorConfiguration {

    @Bean
    public ComplexCalculator complexCalculator() {
        return new ComplexCalculatorImpl();
    }

}
