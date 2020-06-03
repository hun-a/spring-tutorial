package io.huna.spring.calculator;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter @Setter
@Configurable
@Component
@Scope("prototype")
public class Complex {

    private int real;

    private int imaginary;

    private ComplexFormatter formatter;

    @Builder
    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    @Autowired
    public void setFormatter(ComplexFormatter formatter) {
        this.formatter = formatter;
    }

    @Override
    public String toString() {
        return formatter.format(this);
    }

}
