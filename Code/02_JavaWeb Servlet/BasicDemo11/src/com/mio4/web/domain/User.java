package com.mio4.web.domain;

public class User {
	private String username;
	private String password;

	public void setName(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return username;
	}

	public String getPassword() {
		return password;
	}
}
