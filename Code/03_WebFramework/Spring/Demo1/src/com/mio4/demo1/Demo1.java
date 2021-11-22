package com.mio4.demo1;

import org.apache.log4j.Logger;
import org.junit.Test;

public class Demo1 {
	//创建日志对象
	private Logger logger = Logger.getLogger(Demo1.class);

	@Test
	public void test1(){
		logger.info("Something");
	}

}
