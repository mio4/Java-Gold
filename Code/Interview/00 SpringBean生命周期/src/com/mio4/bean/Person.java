package com.mio4.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements BeanFactoryAware,BeanNameAware,
        InitializingBean,DisposableBean {

    private String name;
    private String address;
    private Integer phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person(){
        System.out.println("[构造器]调用Person构造器进行实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("[注入属性]注入属性name");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("[注入属性]注入属性address");
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        System.out.println("[注入属性]注入属性phone");
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                '}';
    }

    //BeanFactoryAware接口
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[BeanFactory接口调用]BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    //BeanNameAware接口
    @Override
    public void setBeanName(String s) {
        System.out.println("[BeanNameAware接口调用]BeanNameAware.setBeanName()");
    }

    //DisposableBean
    @Override
    public void destroy() throws Exception {
        System.out.println("[DisposableBean]调用DisposableBean.destory()");
    }

    //InitializingBean接口
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[InitializingBean]调用InitializingBean.afterPropertiesSet()");
    }

    /**
     * <bean> init-method
     */
    public void myInitialize(){
        System.out.println("[init-method]指定初始化方法");
    }

    /**
     * <bean> deestroy-method
     */
    public void myDestroy(){
        System.out.println("[destroy-method]指定销毁方法");
    }
}
