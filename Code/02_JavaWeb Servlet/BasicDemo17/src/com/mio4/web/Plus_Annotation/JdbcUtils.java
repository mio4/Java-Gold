package com.mio4.web.Plus_Annotation;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	@JdbcInfo(url = "jdbc:mysql://localhost:3306/day16")
	public static Connection getConnection() throws NoSuchMethodException, ClassNotFoundException, SQLException {
		//1.获取字节码文件
		Class clazz = JdbcUtils.class;
		//2.获取Connection
		Method method = clazz.getMethod("getConnection");
		//3.判断方法上是否有注解
		if(method.isAnnotationPresent(JdbcInfo.class)) {

			//4.获取注解属性
			JdbcInfo info = method.getAnnotation(JdbcInfo.class);
			String driverClass = info.driverClass();
			String url = info.url();
			String user = info.user();
			String password = info.password();

			//5.注册驱动
			Class.forName(driverClass);

			//6.获取链接
			return DriverManager.getConnection(url,user,password);
		}

		return null;
	}

	public static void main(String[] args) throws NoSuchMethodException, SQLException, ClassNotFoundException {
		System.out.println(getConnection());
	}
}
