package com.demo.aop_demo2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(String in.strikes.aopDemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint) {
//
//        Object[] arr = joinPoint.getArgs();
//
//        System.out.println("Student is going to be saved");
//
    ////        boolean allowed = false;
    ////
    ////        if(!allowed) {
    ////            throw new RuntimeException("Method Execution not allowed");
    ////        }
//    }

//    @AfterReturning(
//       value = "execution(" +
//               "* in.strikes.aopDemo.service.StudentService" +
//               ".createStudent(..))",
//       returning = "result")
//    public void logAfterReturningMethod(Student result) {
//        //System.out.println("logAfterReturningMethod called");
//
//        result.setName("Rohit");
//        result.setAge(21);
//
//        System.out.println("Intercepted createStudent()");
//    }

//    @AfterThrowing(
//            value = "execution(* in.strikes.aopDemo.service.StudentService.createStudent(..))",
//            throwing = "exception")
//    public void logAfterThrowingMethod(RuntimeException exception) {
//        System.out.println("Exception type: " + exception.getClass().getName());
//        System.out.println("Exception Message: " + exception.getMessage());
//    }
//
//    @After(
//            value = "execution(* in.strikes.aopDemo.service.StudentService.createStudent(..))")
//    public void logAfterMethod() {
//        System.out.println("logAfterMethod executed");
//    }

//    @Around(
//            value = "execution(* in.strikes.aopDemo.service.StudentService.createStudent(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting :" + joinPoint.getSignature().getName());
//
//        try {
//            Object result = joinPoint.proceed();
//
//            System.out.println("Execution Successful");
//
//            return result;
//        }
//        catch(Exception e) {
//            System.out.println("Execution Failed: " + e.getMessage());
//            throw e;
//        }
//
//        finally {
//            System.out.println("Execution Completed");
//        }
//    }



    @Around(
            value = "execution(* in.strikes.aopDemo.service.StudentService.dummyMethod(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

//       Object[] arr =  joinPoint.getArgs();
//
//       String originalString = (String) arr[0];
//
//       String modifiedString = originalString.toUpperCase();
//
//       Object[] modifiedArr = {
//               modifiedString
//       };
//
//       String returnType = (String) joinPoint.proceed(modifiedArr);
//
//       returnType = returnType + " : String Intercepted";
//
//       return returnType;

        Object return1 = joinPoint.proceed();

        System.out.println("Intercepted request calliong again");

        Object return2 = joinPoint.proceed();

        return return2;
    }
}








