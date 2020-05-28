package io.huna.spring.calculator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    @Override
    public double add(double a, double b) {
        double result = a + b;
        System.out.printf("%.3f + %.3f = %.3f\n", a, b, result);
        return result;
    }

    @Override
    public double sub(double a, double b) {
        double result = a - b;
        System.out.printf("%.3f - %.3f = %.3f\n", a, b, result);
        return result;
    }

    @Override
    public double mul(double a, double b) {
        double result = a * b;
        System.out.printf("%.3f * %.3f = %.3f\n", a, b, result);
        return result;
    }

    @Override
    public double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero");
        }
        double result = a / b;
        System.out.printf("%.3f / %.3f = %.3f\n", a, b, result);
        return result;
    }

}
