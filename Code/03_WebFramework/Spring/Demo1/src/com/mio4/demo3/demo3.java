package com.mio4.demo3;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo3 {

	@Test
	public void save(){
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.save();
	}

	/**
	 * 测试依赖注入
	 * 使用工厂
	 */
	@Test
	public void save2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml"); //创建工厂→加载配置文件→创建对象
		CustomerServiceImpl customerService = (CustomerServiceImpl) applicationContext.getBean("customerService"); //获取对象
		customerService.save();
	}
}
