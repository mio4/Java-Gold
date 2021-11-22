package com.mio4.demo1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * AOP 注解
 */
@Aspect
public class MyAspectAnno {

    @Pointcut(value="execution(public void com.mio4.demo1.CustomerDaoImpl.save())")
    public void pc(){}

    @Before(value="MyAspectAnno.pc()")
    public void log(){
        System.out.println("set some log~");
    }

    @After(value="MyAspectAnno.pc()")
    public void afterLog(){
        System.out.println("set some log after~");
    }

    @Around(value="MyAspectAnno.pc()")
    public void aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around 1");
        joinPoint.proceed();
        System.out.println("around 2");
    }

}
