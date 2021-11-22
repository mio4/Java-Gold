package com.mio4.example1;

import com.mio4.HelloServlet;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Demo {

	@Test
	public void f1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Map<String,String> map = new HashMap<String,String>();
		map.put("/hello","com.mio4.HelloServlet");

		String value = map.get("/hello");
		Class clazz = Class.forName(value);
		HelloServlet h = (HelloServlet) clazz.newInstance();
		Method method = clazz.getMethod("add");
		method.invoke(h);
	}

	@Test
	public void f2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, DocumentException {
		Document doc = new SAXReader().read("F:\\Learn-Java\\Head First Java Web\\BasicDemo0\\xml\\web.xml");
		Node servletClass = doc.selectSingleNode("//servlet-class");
		Node urlPattern = doc.selectSingleNode("//url-pattern");

		String classText = servletClass.getText();
		String urlText = urlPattern.getText();
		Map<String,String> map = new HashMap<String,String>();
		map.put(urlText,classText);

		String value = map.get("/hello");
		Class clazz = Class.forName(value);
		HelloServlet h = (HelloServlet) clazz.newInstance();
		Method method = clazz.getMethod("add");
		method.invoke(h);
	}
}
