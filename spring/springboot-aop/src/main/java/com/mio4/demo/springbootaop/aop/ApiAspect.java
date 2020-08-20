package com.mio4.demo.springbootaop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author mio4
 * @date 2020-08-19 22:31
 */

@Aspect
@Component
public class ApiAspect {

    /**
     * 定义一个切点
     */
    @Pointcut("execution(* com.mio4.demo.springbootaop.controller.*.*(..))")
    public void allControllerPointcut(){ }

    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     * @param jp
     */
    @Before("allControllerPointcut()")
    public void beforeMethod(JoinPoint jp){
        String methodName = jp.getSignature().getName();
        System.out.println("【前置通知】the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     * @param jp
     * @param result
     */
    @AfterReturning(value="execution(* com.mio4.demo.springbootaop.controller.*.*(..))",returning="result")
    public void afterReturningMethod(JoinPoint jp, Object result){
        String methodName = jp.getSignature().getName();
        System.out.println("【返回通知】the method 【" + methodName + "】 ends with 【" + result + "】");
    }

    /**
     * 后置通知：目标方法执行之后执行以下方法体的内容，不管是否发生异常。
     * @param jp
     */
    @After("execution(* com.mio4.demo.springbootaop.controller.*.*(..))")
    public void afterMethod(JoinPoint jp){
        System.out.println("【后置通知】this is a afterMethod advice...");
    }

    /**
     * 异常通知：目标方法发生异常的时候执行以下代码
     */
    @AfterThrowing(value="execution(* com.mio4.demo.springbootaop.controller.*.*(..))",throwing="e")
    public void afterThorwingMethod(JoinPoint jp, NullPointerException e){
        String methodName = jp.getSignature().getName();
        System.out.println("【异常通知】the method 【" + methodName + "】 occurs exception: " + e);
    }

    /**
     * 环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     * @return
     */
    @Around(value="execution(* com.mio4.demo.springbootaop.controller.*.*(..))")
    public Object aroundMethod(ProceedingJoinPoint jp){
        String methodName = jp.getSignature().getName();
        Object result = null;
        try {
            System.out.println("【环绕通知中的--->前置通知】：the method 【" + methodName + "】 begins with " + Arrays.asList(jp.getArgs()));
            //执行目标方法
            result = jp.proceed();
            System.out.println("【环绕通知中的--->返回通知】：the method 【" + methodName + "】 ends with " + result);
        } catch (Throwable e) {
            System.out.println("【环绕通知中的--->异常通知】：the method 【" + methodName + "】 occurs exception " + e);
        }

        System.out.println("【环绕通知中的--->后置通知】：-----------------end.----------------------");
        return result;
    }


    //-------------------------------------------------------------------------------------
    @Around("allControllerPointcut()")
    public Object aroundMethodWithProceeding(ProceedingJoinPoint pjd){
        Object result;
        try {
            //前置通知
            System.out.println("[aroundMethodWithProceeding] 目标方法执行前...");
            //demo-1. 执行原有方法
            //result = pjd.proceed();

            //demo-2. 用新的参数值执行目标方法
            result = pjd.proceed(new Object[]{"mio4"});
            //返回通知
            System.out.println("[aroundMethodWithProceeding] 目标方法返回结果后...");
        } catch (Throwable e) {
            //异常通知
            System.out.println("[aroundMethodWithProceeding] 执行目标方法异常后...");
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("[aroundMethodWithProceeding] 目标方法执行后...");
        //必须要将ProceedingJoinPoint执行结果返回
        return result;
    }
}
