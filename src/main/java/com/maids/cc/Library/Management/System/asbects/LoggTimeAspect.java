package com.maids.cc.Library.Management.System.asbects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggTimeAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggTimeAspect.class);

    @Pointcut(value = "execution(* com.maids.cc.Library.Management.System.service..*(..))")
    private void logTimePointCut(){}


    @Around(value = "logTimePointCut()")
    public Object logTime(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Method {} completed in {} ms", joinPoint.getSignature(), timeTaken);

        return result;
    }

}
