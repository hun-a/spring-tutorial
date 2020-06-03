package io.huna.spring.calculator;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Setter
@Component
public class ComplexFormatter {

    @Value("(a + bi)")
    private String pattern;

    public String format(Complex complex) {
        return pattern.replaceAll("a", Integer.toString(complex.getReal()))
                .replaceAll("b", Integer.toString(complex.getImaginary()));
    }

}
