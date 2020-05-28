package io.huna.spring.calculator;

public class MinCalculatorImpl implements MinCalculator {

    @Override
    public double min(double a, double b) {
        double result = (a <= b) ? a : b;
        System.out.printf("Min(%.3f, %.3f) = %.3f\n", a, b, result);
        return result;
    }

}
