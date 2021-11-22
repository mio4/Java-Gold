package com.mio4.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo1 {

	@Test
	public void test1(){
		UserService userService = new UserServiceImpl();
		userService.sayHello();
	}

	/**
	 * 使用注解的方式
	 */
	@Test
	public void test2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.sayHello();
	}


}
