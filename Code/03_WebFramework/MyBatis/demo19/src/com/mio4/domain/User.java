package com.mio4.domain;

import java.io.Serializable;

/**
 * CREATE TABLE TB_USER(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	loginname VARCHAR(20) UNIQUE, #用户名
 * 	password VARCHAR(20), #密码
 * 	username VARCHAR(20), #用户名
 * 	phone VARCHAR(20), #电话
 * 	address VARCHAR(255)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {
    private Integer id;
    private String loginname;
    private String password;
    private String username;
    private String phone;
    private String address;

    public User(){

    }

    public User(Integer id, String loginname, String password, String username, String phone, String address) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.username = username;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
