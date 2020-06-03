package io.huna.spring.config;

import io.huna.spring.aop.ComplexCachingAspect;
import io.huna.spring.calculator.*;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("io.huna.spring")
public class CalculatorConfiguration {

    @Bean
    public ComplexCalculator complexCalculator() {
        return new ComplexCalculatorImpl();
    }

    @Bean
    public ComplexCachingAspect complexCachingAspect() {
        Map<String , Complex> cache = new HashMap<>();
        cache.put("2,3", new Complex(2, 3));
        cache.put("3,5", new Complex(3, 5));

        ComplexCachingAspect complexCachingAspect = Aspects.aspectOf(ComplexCachingAspect.class);
        complexCachingAspect.setCache(cache);
        return complexCachingAspect;
    }

}
