package io.huna.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Order(1)
@Aspect
@Component
public class CalculatorLoggingAspect {

    /**
     * Advice: @Before
     * Joinpoint: parameter - joinPoint
     * Pointcut: * *.*(..)
     *
     * @param joinPoint
     */
    @Before("execution(* *.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Join point kind: {}", joinPoint.getKind());
        log.info("Signature declaring type: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Signature name: {}", joinPoint.getSignature().getName());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
        log.info("Target class: {}", joinPoint.getTarget().getClass().getName());
        log.info("This class: {}", joinPoint.getThis().getClass().getName());
    }

}
