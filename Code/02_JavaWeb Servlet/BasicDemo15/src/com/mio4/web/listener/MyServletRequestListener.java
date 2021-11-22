package com.mio4.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class MyServletRequestListener implements ServletRequestListener {
	@Override
	public void requestDestroyed(ServletRequestEvent sre){
		System.out.println("请求被销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre){
		System.out.println("请求被创建");
	}
}
