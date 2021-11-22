package com.mio4.web.Plus_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 使用注解来代替JDBC配置文件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JdbcInfo {
	String driverClass() default "com.mysql.jdbc.Driver";
	String url();
	String user() default "root";
	String password() default "123456";
}
