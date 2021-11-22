package com.mio4;

public class HelloServlet {

	public void add(){
		System.out.println("无参方法");
	}

	public int add(int i){
		System.out.println(i);
		return i;
	}


	public int add(int i, int j){
		System.out.println(i);
		System.out.println(j);
		return i+j;
	}
}
