package com.mio4.action;

/**
 * 处理用户请求
 */
public class HelloAction {

	/**
	 * say hello
	 * @return
	 */
	public String sayHello(){
		System.out.println("Hello,Strut2!");
		return "ok";
	}

	/**
	 * 方法默认值
	 * @return
	 */
	public String execute(){
		System.out.println("execute执行");
		return null;
	}
}
