package io.huna.spring.aop;

import io.huna.spring.calculator.MaxCalculator;
import io.huna.spring.calculator.MaxCalculatorImpl;
import io.huna.spring.calculator.MinCalculator;
import io.huna.spring.calculator.MinCalculatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorIntroduction {

    @DeclareParents(
            value = "io.huna.spring.calculator.ArithmeticCalculatorImpl",
            defaultImpl = MaxCalculatorImpl.class)
    public MaxCalculator maxCalculator;

    @DeclareParents(
            value = "io.huna.spring.calculator.ArithmeticCalculatorImpl",
            defaultImpl = MinCalculatorImpl.class)
    public MinCalculator minCalculator;
}
