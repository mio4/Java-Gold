package com.mio4.demo3;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class MyAspectXML {

    /**
     * 通知
     */
    public void log(){
        System.out.println("save a log~");
    }


    public void beforeLog(){
        System.out.println("before the method, print the log~");
    }

    public void afterLog(){
        System.out.println("after the method , print the log~");
    }

    public void afterReturnLog(){
        System.out.println("after method return, print the log~");
    }

    public void roundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("round method, print the log 1~");
        joinPoint.proceed();
        System.out.println("round method, print the log 2~");
    }

}
