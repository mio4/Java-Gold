package com.mio4.domain;

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
public class Employee {
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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", sal=" + sal +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
