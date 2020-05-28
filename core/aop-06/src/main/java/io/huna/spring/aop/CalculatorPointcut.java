package io.huna.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointcut {

    @Pointcut("within(io.huna.spring.calculator.ArithmeticCalculator+)")
    public void arithmeticOperator() {}

    @Pointcut("within(io.huna.spring.calculator.UnitCalculator+)")
    public void unitOperation() {}

    @Pointcut("arithmeticOperator() || unitOperation()")
    public void loggingRequired() {}

    @Pointcut("loggingRequired() && target(target) && args(a, b)")
    public void loggingRequiredWithParams(Object target, double a, double b) {}

}