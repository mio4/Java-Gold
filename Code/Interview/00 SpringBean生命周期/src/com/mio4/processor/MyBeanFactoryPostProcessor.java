package com.mio4.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor(){
        super();
        System.out.println("[MyBeanFactoryPostProcessor]实现类构造器");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("[MyBeanFactoryPostProcessor]调用postProcessBeanFactory");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("person");
        beanDefinition.getPropertyValues().addPropertyValue("phone","461152465");
    }
}
