package com.mio4.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor(){
        super();
        System.out.println("[MyBeanPostProcessor]类构造器");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[MyBeanPostProcessor]postProcessBeforeInitialization对属性进行修改");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[MyBeanPostProcessor]postProcessAfterInitialization对属性进行修改");
        return bean;
    }
}
