package com.mio4.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo4 {

	/**
	 * 依赖注入：
	 * 1.构造器
	 * 2.Setter
	 * 3.SpEl
	 */
	@Test
	public void test1(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Car1 car1 = (Car1) applicationContext.getBean("Car1");
		System.out.println(car1.toString());

		Person person = (Person) applicationContext.getBean("Person");
		System.out.println(person);

		Car2 car2 = (Car2) applicationContext.getBean("Car2");
		System.out.println(car2);
	}

	/**
	 * 集合注入
	 */
	@Test
	public void test2(){
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml","com/mio4/demo6/applicationContext2.xml");
		User user = (User) applicationContext.getBean("User");
		System.out.println(user);
	}
}
