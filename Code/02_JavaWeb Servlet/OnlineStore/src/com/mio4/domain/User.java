package com.mio4.domain;

import java.util.Date;

/**
 * 用户
 * CREATE TABLE `user` (
 *   `uid` varchar(32) NOT NULL,
 *   `username` varchar(20) DEFAULT NULL,
 *   `password` varchar(100) DEFAULT NULL,
 *   `name` varchar(20) DEFAULT NULL,
 *   `email` varchar(30) DEFAULT NULL,
 *   `telephone` varchar(20) DEFAULT NULL,
 *   `birthday` varchar(20) DEFAULT NULL,
 *   `sex` varchar(10) DEFAULT NULL,
 *   `state` int(11) DEFAULT NULL,
 *   `code` varchar(64) DEFAULT NULL,
 *   PRIMARY KEY (`uid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User {
	private String uid;
	private String username;
	private String password;

	private String name;
	private String email;
	private String telephone;

	//private Date birthday;
	private String birthday;
	private String sex;
	//用户状态state: 0-未激活 1-激活
	private Integer state = 0;
	private String code;

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUid() {
		return uid;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getSex() {
		return sex;
	}

	public Integer getState() {
		return state;
	}

	public String getCode() {
		return code;
	}
}
