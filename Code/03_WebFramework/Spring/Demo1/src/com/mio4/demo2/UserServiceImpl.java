package com.mio4.demo2;

public class UserServiceImpl implements UserService{

	private String name;

	public void setName(String name){
		this.name = name;
	}

	@Override
	public void sayHello() {
		System.out.println("Hello,Spring " + name);
	}

	public void init(){
		System.out.println("init~");
	}

	public void destroy(){
		System.out.println("destroy");
	}
}
