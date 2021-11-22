package com.mio4.web.reflect;

import com.mio4.web.domain.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 本例子对于反射的使用进行了部分测试
 * 1.可以通过一个Constructor类获取类的对象 constructor.newInstance(...)
 * 2.可以通过一个Class对象获取对应的对象
 * 3.可以获取不同的构造器
 */

public class Demo {

	/**
	 * 反射案例1
	 * 使用构造器创建一个对象
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	@Test
	public void f1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		//1.获取Class对象
		Class clazz = Class.forName("com.mio4.web.domain.Person");
		//2.获取构造器
		//根据传入参数的不同，可以得到不同的构造器
		//Constructor constructor = clazz.getConstructor();
		Constructor constructor = clazz.getConstructor(String.class,String.class);

		//3.通过构造器去创建一个对象，返回类型为Class，需要进行类型转换
		Person p = (Person) constructor.newInstance("mio","20");

	}

	/**
	 * 反射案例2
	 * 通过Method对象使用方法
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@Test
	public void f2() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		//1.获取Class对象
		Class clazz = Class.forName("com.mio4.web.domain.Person");
		Person person = (Person) clazz.newInstance();

		//2.获取方法
		Method method = clazz.getDeclaredMethod("sleep",String.class);
		method.setAccessible(true);
		System.out.println(method.invoke(person,"mio"));
	}

	/**
	 * 反射案例3
	 * 获取私有方法，并且执行
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 */
	@Test
	public void f3() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
		//1.获取Class对象
		Class clazz = Class.forName("com.mio4.web.domain.Person");
		Person person = (Person) clazz.newInstance();
		//2.获取私有的方法，设置Accessible
		Method method = clazz.getDeclaredMethod("sleep");
		method.setAccessible(true);
		//3.使用方法
		method.invoke(person);
	}
}
