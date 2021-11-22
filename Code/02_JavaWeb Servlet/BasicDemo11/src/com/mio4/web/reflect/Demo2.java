package com.mio4.web.reflect;

import java.lang.reflect.Method;

/**
 * Invoke方法的使用案例
 */
public class Demo2 {
	public static void main(String[] args){
		String[] names = {"tom","cat","mio"};
		Class<?> clazz = Test.class;
		try{
			Method method = clazz.getMethod("sayHi",String.class);
			for(String name : names){
				//invoke的参数为一个对象以及对应的参数
				//1.普通的方法调用 对象名.方法名（参数）
				//2.反射的方法调用 方法名.invoke(对象名,参数)
				//3.可以简单的理解为交换了顺序
				method.invoke(clazz.newInstance(),name);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

class Test{
	public void sayHi(String name){
		System.out.println("Hi " + name);
	}
}
