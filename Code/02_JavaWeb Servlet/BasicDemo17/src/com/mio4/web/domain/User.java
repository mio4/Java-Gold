package com.mio4.web.domain;

import com.mio4.web.enums.Color;

import java.util.Date;
import java.util.List;

public class User {
	@SuppressWarnings("unused")
	private String id;
	@SuppressWarnings("unused")
	private String name;
	private List list;

	private Color RED;

	@Deprecated
	public static void add2(){

	}

	public static void main(String[] args){
		new Date().toLocaleString();
		add2();
	}

}
