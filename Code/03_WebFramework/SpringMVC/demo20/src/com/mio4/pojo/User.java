package com.mio4.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String username;
    private String sex;
    private Integer age;

    public User(){

    }

    public User(String username, String sex, Integer age){
        this.username = username;
        this.sex = sex;
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }
}
