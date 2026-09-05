package com.demo.aop_demo2.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

public class SimpleAspect {

     @Around("@Annotation(com.demo.aop_demo2.annotation.TrackExecutionTime)")
     public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

         long startTime = System.currentTimeMillis();

         try{
             return joinPoint.proceed();
         }
         finally {
             long endTime = System.currentTimeMillis();
             long executionTime = endTime - startTime;

             String methodName = joinPoint.getSignature().getName();

             System.out.println("Time taken: " + executionTime + " ms");
         }
     }
}
