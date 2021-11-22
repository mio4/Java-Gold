package com.mio4.web.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {
	private int id;
	private String name;

	public User(){

	}

	public User(int id,String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event){
		System.out.println("User绑定到Sesion");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event){
		System.out.println("User解绑");
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
