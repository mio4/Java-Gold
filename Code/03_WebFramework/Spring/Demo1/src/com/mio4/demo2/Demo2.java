package com.mio4.demo2;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Demo2 {

	/**
	 * ~~测试Spring IoC~~
	 */
	@Test
	public void test1(){
		UserService userService = new UserServiceImpl();
		((UserServiceImpl) userService).setName("mio");
		userService.sayHello();
	}

	/**
	 *使用Spring框架
	 */
	@Test
	public void test2(){
		//创建工厂，加载核心配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从工厂中获取对象
		UserServiceImpl userServiceImpl = (UserServiceImpl) applicationContext.getBean("userService");
		//调用对象的方法
		userServiceImpl.sayHello();

	}

	@Test
	public void test3(){
		//创建工厂，加载核心配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从工厂中获取对象
		UserService userService = (UserService) applicationContext.getBean("userService");
		//调用对象的方法
		userService.sayHello();
	}

	/**
	 * 测试BeanFactory
	 * 方法已过时，不推荐使用
	 */
	@Test
	public void test4(){
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		UserService userService = (UserService) factory.getBean("userService");
		userService.sayHello();
	}

	/**
	 * 关闭工厂，工厂里所有的对象都会被销毁
	 */
	@Test
	public void test5(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.sayHello();
		((ClassPathXmlApplicationContext) applicationContext).close();
	}


	/**
	 * 依赖注入
	 */
	@Test
	public void test6(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService userService = (UserService) applicationContext.getBean("userService");
		userService.sayHello();
	}
}
