package com.mio4.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    public MyInstantiationAwareBeanPostProcessor(){
        super();
        System.out.println("[MyInstantiationAwareBeanPostProcessor]类构造器");
    }


    /**
     * 实例化bean之前调用
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation]");
        return null;
    }

    /**
     * 实例化bean之后调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("[MyInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation]");
        return true;
    }


    /**
     * 接口方法-设置某个属性时调用
     * @param pvs
     * @param pds
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public PropertyValues postProcessPropertyValues(
            PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName)
            throws BeansException {

        System.out.println("[MyInstantiationAwareBeanPostProcessor.postProcessPropertyValues]");
        return pvs;
    }

}
