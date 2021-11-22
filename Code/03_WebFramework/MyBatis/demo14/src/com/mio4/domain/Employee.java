package com.mio4.domain;

import java.io.Serializable;

/**
 * CREATE TABLE TB_EMPLOYEE(
 * 	id INT(11) PRIMARY KEY AUTO_INCREMENT,
 * 	loginname VARCHAR(20),
 * 	password VARCHAR(20),
 * 	name VARCHAR(20) DEFAULT NULL,
 * 	sex char(2) DEFAULT NULL,
 * 	age INT(11) DEFAULT NULL,
 * 	phone VARCHAR(20),
 * 	sal DOUBLE,
 * 	state VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Employee implements Serializable {
    private Integer id;
    private String loginname;
    private String password;
    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private Double sal;
    private String state;

    public Employee(){

    }

    public Employee(Integer id, String loginname, String password, String name, String sex, Integer age, String phone, Double sal, String state) {
        this.id = id;
        this.loginname = loginname;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.sal = sal;
        this.state = state;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLoginname(String loginame) {
        this.loginname = loginame;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public Double getSal() {
        return sal;
    }

    public String getState() {
        return state;
    }
}
