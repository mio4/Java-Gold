package com.mio4.web.domain;

public class Person {
	private String username;
	private String password;

	public Person(){
		System.out.println("无参构造器");
	}

	public Person(String username,String password){
		this.username = username;
		this.password = password;
		System.out.println("有参构造器");
	}

	public void eat(){
		System.out.println("will eat");
	}

	public void eat(String name){
		System.out.println(name + "will eat");
	}

	private void sleep(){
		System.out.println("will sleep");
	}

	private String sleep(String name){
		return (name + " will slepp");
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}

