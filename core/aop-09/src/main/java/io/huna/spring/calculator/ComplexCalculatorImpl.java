package io.huna.spring.calculator;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ComplexCalculatorImpl implements ComplexCalculator {

    @Override
    public Complex add(Complex a, Complex b) {
        Complex result = new Complex(a.getReal() + b.getReal(), a.getImaginary() + b.getImaginary());
        System.out.printf("%s + %s = %s\n", a.toString(), b.toString(), result.toString());
        return result;
    }

    @Override
    public Complex sub(Complex a, Complex b) {
        Complex result = new Complex(a.getReal() - b.getReal(), a.getImaginary() - b.getImaginary());
        System.out.printf("%s - %s = %s\n", a.toString(), b.toString(), result.toString());
        return result;
    }

}
