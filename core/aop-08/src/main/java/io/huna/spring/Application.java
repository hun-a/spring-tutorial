package io.huna.spring;

import io.huna.spring.calculator.Complex;
import io.huna.spring.calculator.ComplexCalculator;
import io.huna.spring.config.CalculatorConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ComplexCalculator complexCalculator = context.getBean(ComplexCalculator.class);

        complexCalculator.add(
                Complex.builder().real(1).imaginary(2).build(),
                Complex.builder().real(2).imaginary(3).build()
        );
        complexCalculator.add(
                Complex.builder().real(1).imaginary(2).build(),
                Complex.builder().real(2).imaginary(3).build()
        );
        complexCalculator.sub(
                Complex.builder().real(5).imaginary(8).build(),
                Complex.builder().real(2).imaginary(3).build()
        );
    }

}
