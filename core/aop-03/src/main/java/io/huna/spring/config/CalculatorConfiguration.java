package io.huna.spring.config;

import io.huna.spring.calculator.ArithmeticCalculator;
import io.huna.spring.calculator.ArithmeticCalculatorImpl;
import io.huna.spring.calculator.UnitCalculator;
import io.huna.spring.calculator.UnitCalculatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("io.huna.spring")
public class CalculatorConfiguration {

    @Bean
    public ArithmeticCalculator arithmeticCalculator() {
        return new ArithmeticCalculatorImpl();
    }

    @Bean
    public UnitCalculator unitCalculator() {
        return new UnitCalculatorImpl();
    }

}
