package io.huna.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CalculatorPointcut {

    @Pointcut("execution(* *.*(..))")
    public void loggingOperation() {}

}
