package com.mio4.action1;

import com.opensymphony.xwork2.Action;

public class Demo2Action implements Action {

	@Override
	public String execute() throws Exception {
		System.out.println("demo2Action实现了Action接口");
		//return null
		//return SUCCESS;
		return NONE; //页面不跳转
	}
}
