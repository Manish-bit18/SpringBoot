package com.demo.aop_demo2.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 2000;

    String operation() default "";

}