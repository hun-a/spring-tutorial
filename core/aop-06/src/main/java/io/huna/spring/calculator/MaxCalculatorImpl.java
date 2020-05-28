package io.huna.spring.calculator;

public class MaxCalculatorImpl implements MaxCalculator {

    @Override
    public double max(double a, double b) {
        double result = (a >= b) ? a : b;
        System.out.printf("Max(%.3f, %.3f) = %.3f\n", a, b, result);
        return result;
    }

}
