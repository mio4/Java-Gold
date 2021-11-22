package com.mio4.web.AnnotationDemo;

public class MyTest_Test {

	@MyTest
	public void f1(){
		System.out.println("f1 method done!");
	}

	@MyTest
	public void f2(){
		System.out.println("f2 method done!");
	}

	public void f3(){
		System.out.println("f3 method done!");
	}
}
