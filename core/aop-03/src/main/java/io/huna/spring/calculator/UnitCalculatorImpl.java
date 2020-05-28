package io.huna.spring.calculator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UnitCalculatorImpl implements UnitCalculator {

    @Override
    public double kilogramToPound(double kilogram) {
        double pound = kilogram * 2.2;
        System.out.printf("kilogram: %.3f, pound: %.3f\n", kilogram, pound);
        return pound;
    }

    @Override
    public double kilometerToMile(double kilometer) {
        double mile = kilometer * 0.62;
        System.out.printf("kilometer: %.3f, mile: %.3f\n", kilometer, mile);
        return mile;
    }

}
