package io.huna.spring.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
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
        log.info("The method {}() begins with {}", joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }

    /**
     * Advice: @After
     * Joinpoint: parameter - joinPoint
     * Pointcut: * *.*(..)
     *
     * @param joinPoint
     */
    @After("execution(* *.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("The method {}() ends", joinPoint.getSignature().getName());
    }

    /**
     * Advice: @AfterReturning
     * Joinpoint: parameter - joinPoint
     * Pointcut: * *.*(..)
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(pointcut = "execution(* *.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("The method {}() ends with {}", joinPoint.getSignature().getName(), result);
    }

    /**
     * Advice: @AfterThrowing
     * Joinpoint: parameter - joinPoint
     * Pointcut: * *.*(..)
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(pointcut = "execution(* *.*(..))", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("[AROUND] An exception {} has been thrown in {}()", e, joinPoint.getSignature().getName());
    }

    /**
     * Advice: @Around
     * Joinpoint: parameter - joinPoint
     * Pointcut: * *.*(..)
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* *.*(..))")
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
