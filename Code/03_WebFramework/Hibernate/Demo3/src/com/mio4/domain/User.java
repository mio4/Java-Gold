package com.mio4.domain;

public class User {
	private Integer id;
	private String name;
	private Integer age;
	private int version; //版本号

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setVersion(int version){
		this.version = version;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public int getVersion(){
		return this.version;
	}
}
