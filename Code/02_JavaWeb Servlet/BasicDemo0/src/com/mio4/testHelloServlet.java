package com.mio4;

import com.mio4.HelloServlet;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class testHelloServlet {

	@Test
	public void f1(){
		HelloServlet h = new HelloServlet();
		h.add();
		h.add(1,2);
	}

	@Test
	public void f2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
		Class clazz = Class.forName("com.mio4.HelloServlet");
		HelloServlet h = (HelloServlet) clazz.newInstance();
		h.add();
	}

	@Test
	public void f3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class clazz = Class.forName("com.mio4.HelloServlet");
		Method method = clazz.getMethod("add");
		HelloServlet h = (HelloServlet) clazz.newInstance();
		method.invoke(h);
	}

	@Test
	public void f4() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Class clazz = HelloServlet.class;
		HelloServlet h = (HelloServlet) clazz.newInstance();
		Method method = clazz.getMethod("add",int.class,int.class);
		method.invoke(h,1,2);
	}
}
