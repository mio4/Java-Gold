package com.mio4.web.AnnotationDemo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 模仿Junit测试：对于@MyTest注解的函数能够直接运行
 */
public class Main {
	/*public static void main(String[] args) {
		Class clazz = MyTest_Test.class;
		Method[] methods = clazz.getMethods();
		for (Method m : methods){
			System.out.println(m.getName());
		}
	}*/

	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
		Class clazz = MyTest_Test.class;
		Method[] methods = clazz.getMethods();
		for(Method m : methods){
			Boolean isAnno = m.isAnnotationPresent(MyTest.class);
			if(isAnno)
				//System.out.println(m.getName());
				m.invoke(clazz.newInstance());
		}
	}
}
