package com.mio4.domain;

/**
 * JavaBean
 */

public class User {
	private int id;
	private String username;
	private String password;
	private String email;
	private String name;
	private String sex;
	private String birthday;
	private String hobby;

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getHobby() {
		return hobby;
	}
}
