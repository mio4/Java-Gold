package com.mio4.domain;

public class Person {
	private String pid; //主键是字符串类型
	private String pname;

	public void setPid(String pid) {
		this.pid = pid;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPid() {
		return pid;
	}

	public String getPname() {
		return pname;
	}
}
