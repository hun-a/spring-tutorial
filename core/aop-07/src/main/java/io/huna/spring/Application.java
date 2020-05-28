package io.huna.spring;

import io.huna.spring.calculator.ArithmeticCalculator;
import io.huna.spring.calculator.UnitCalculator;
import io.huna.spring.config.CalculatorConfiguration;
import io.huna.spring.status.Counter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

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

        Counter arithmeticCounter = (Counter) arithmeticCalculator;
        System.out.printf("\nInvoked count of ArithmeticCalculator: %d\n", arithmeticCounter.getCount());

        Counter unitCounter = (Counter) unitCalculator;
        System.out.printf("Invoked count of UnitCalculator: %d\n", unitCounter.getCount());
    }
}
