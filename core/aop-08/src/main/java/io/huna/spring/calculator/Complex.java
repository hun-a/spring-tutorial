package io.huna.spring.calculator;

import lombok.*;

@Builder
@Getter @Setter
@AllArgsConstructor
public class Complex {

    private int real;

    private int imaginary;

    @Override
    public String toString() {
        return String.format("(%d + %di)", real, imaginary);
    }

}
