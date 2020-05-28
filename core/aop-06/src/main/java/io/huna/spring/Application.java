package io.huna.spring;

import io.huna.spring.calculator.ArithmeticCalculator;
import io.huna.spring.calculator.MaxCalculator;
import io.huna.spring.calculator.MinCalculator;
import io.huna.spring.calculator.UnitCalculator;
import io.huna.spring.config.CalculatorConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        MaxCalculator maxCalculator = (MaxCalculator) context.getBean(ArithmeticCalculator.class);
        maxCalculator.max(2, 8);

        MinCalculator minCalculator = (MinCalculator) context.getBean(ArithmeticCalculator.class);
        minCalculator.min(8, 2);

        ArithmeticCalculator arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);
        try {
            arithmeticCalculator.div(4, 0);
        } catch (IllegalArgumentException e) {
        }

        UnitCalculator unitCalculator = context.getBean(UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);
    }
}
