package com.mio4.web.demo;

import java.lang.annotation.Annotation;
import java.util.Date;

public @interface MyAnnotation {
	//注解属性
	int i();
	String s();
	String[] sa();
	Class c();
}
