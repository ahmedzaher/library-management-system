package com.example.library_management_system.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Aspect
@Component
public class ApiDurationAspect {

    @Around("execution(* com.example.library_management_system.controller.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Timestamp timestampBefore = new Timestamp(System.currentTimeMillis());
        Object result = joinPoint.proceed();
        long t = new Timestamp(System.currentTimeMillis()).getTime() - timestampBefore.getTime();
        log.info("api duration time in ms : {}", t);
        return result;
    }
}
