package com.mio4.domain;

import java.io.Serializable;
import java.util.List;

/**
 * CREATE TABLE TB_USER(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	username VARCHAR(20),
 * 	loginname VARCHAR(20),
 * 	password VARCHAR(20),
 * 	phone VARCHAR(10),
 * 	address VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {
    private Integer id; //用户id，主键
    private String username;
    private String loginname;
    private String password;
    private String phone;
    private String address;

    //一个用户可以有多个订单
    private List<Order> orders;

    public User(){

    }

    public User(Integer id,String username,String loginname,String password,String phone,String address){
        this.id = id;
        this.username = username;
        this.loginname = loginname;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orders=" + orders +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
