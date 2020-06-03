package io.huna.spring.aop;

import io.huna.spring.calculator.Complex;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
public class ComplexCachingAspect {

    private final Map<String, Complex> cache = new ConcurrentHashMap<>();

    @Around("call(public io.huna.spring.calculator.Complex.new(int, int)) && args(a, b)")
    public Object cacheAround(ProceedingJoinPoint joinPoint, int a, int b) throws Throwable {
        String key = String.format("%d,%d", a, b);
        Complex complex = cache.get(key);

        if (complex == null) {
            System.out.printf("Cache MISS for (%s)\n", key);
            complex = (Complex) joinPoint.proceed();
            cache.put(key, complex);
        } else {
            System.out.printf("Cache HIT for (%s)\n", key);
        }

        return complex;
    }

}
