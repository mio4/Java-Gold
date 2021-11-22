package com.mio4.web.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 监听ServletContext 属性变化
 */
public class MyServletContextAttri implements ServletContextAttributeListener {
	@Override
	public void attributeAdded(ServletContextAttributeEvent scae){
		System.out.println("ServletContext添加属性 " + scae.getName());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae){
		System.out.println("ServletContext删除属性 " + scae.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae){
		System.out.println("ServletContext替换属性 " + scae.getName());
	}
}
