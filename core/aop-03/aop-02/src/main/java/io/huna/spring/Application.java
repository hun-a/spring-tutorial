package io.huna.spring;

import io.huna.spring.calculator.ArithmeticCalculator;
import io.huna.spring.calculator.UnitCalculator;
import io.huna.spring.config.CalculatorConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CalculatorConfiguration.class);

        ArithmeticCalculator arithmeticCalculator = context.getBean(ArithmeticCalculator.class);
        arithmeticCalculator.add(1, 2);
        arithmeticCalculator.sub(4, 3);
        arithmeticCalculator.mul(2, 3);
        arithmeticCalculator.div(4, 2);
        try {
            arithmeticCalculator.add(-1, 2);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        try {
            arithmeticCalculator.div(4, 0);
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        UnitCalculator unitCalculator = context.getBean(UnitCalculator.class);
        unitCalculator.kilogramToPound(10);
        unitCalculator.kilometerToMile(5);
    }
}
