package com.mio4.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce){
		System.out.println("ServletContext创建");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce){
		System.out.println("ServletContext销毁");
	}
}
