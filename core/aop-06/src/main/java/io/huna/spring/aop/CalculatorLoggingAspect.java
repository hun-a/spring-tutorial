package io.huna.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class CalculatorLoggingAspect {

    @Before("CalculatorPointcut.loggingRequired()")
    public void logBefore(JoinPoint joinPoint) {
        log.info("The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

    @Before("CalculatorPointcut.loggingRequiredWithParams(target, a, b)")
    public void logBeforeWithParams(Object target, double a, double b) {
        log.info("Target class: {}", target.getClass().getName());
        log.info("Arguments: a {}, b {}", a, b);
    }

    @After("CalculatorPointcut.loggingRequired()")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method {}() ends", joinPoint.getSignature().getName());
    }

    @AfterReturning(
            pointcut = "CalculatorPointcut.loggingRequired()",
            returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    @AfterThrowing(
            pointcut = "CalculatorPointcut.loggingRequired()",
            throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("[AROUND] An exception {} has been thrown in {}()", e, joinPoint.getSignature().getName());
    }

    @Around("CalculatorPointcut.loggingRequired()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("[AROUND] The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            log.info("[AROUND] The method {}() ends with {}", joinPoint.getSignature().getName(), result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("[AROUND] Illegal argument {} in {}()", Arrays.toString(joinPoint.getArgs()), joinPoint.getSignature().getName());
            throw e;
        }
    }
}
