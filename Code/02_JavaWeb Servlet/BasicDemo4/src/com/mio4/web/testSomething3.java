package com.mio4.web;

public class testSomething3 {
	public static void main(String[] args){
		//TestClass tc = new TestClass();
		SonClass sc = new SonClass();
	}
}

class TestClass{

	public TestClass(){
		System.out.println("FatherClass Constructor");
	}

	static {
		System.out.println("Father Static");
	}
}

class SonClass extends TestClass{

	public SonClass(){
		System.out.println("SonClass Constructor");
	}

	static {
		System.out.println("SonClass static");
	}
}