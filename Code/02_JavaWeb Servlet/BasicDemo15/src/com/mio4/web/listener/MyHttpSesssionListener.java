package com.mio4.web.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSesssionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent hse){
		System.out.println("session创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse){
		System.out.println("session销毁");
	}

}
