package com.mio4.web.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class User_Serial implements HttpSessionActivationListener,Serializable {
	private int id;
	private String name;

	public User_Serial(){

	}

	public User_Serial(int id,String name){
		this.id = id;
		this.name = name;
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se){
		System.out.println("User 写进磁盘");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se){
		System.out.println("User 从磁盘中读取");
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

