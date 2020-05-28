package io.huna.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(0)
@Component
public class CalculatorValidationAspect {

    @Before("execution(* *.*(double, double))")
    public void validateBefore(JoinPoint joinPoint) {
        for (Object arg: joinPoint.getArgs()) {
            validate((Double) arg);
        }
    }

    private void validate(Double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Positive numbers only");
        }
    }

}
