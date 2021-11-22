package com.mio4.test;

import com.mio4.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

    public static void main(String[] args) {
        System.out.println("[开始初始化容器]");
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("[容器初始化成功]");
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);
        System.out.println("[开始关闭容器]");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }
}
