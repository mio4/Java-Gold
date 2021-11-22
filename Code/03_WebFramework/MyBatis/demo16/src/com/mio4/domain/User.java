package com.mio4.domain;

import java.io.Serializable;

/**
 * create table tb_user(
 * 	id int(11) primary key auto_increment,
 * 	name varchar(20) default null,
 * 	sex varchar(10) default null,
 * 	age int(10) default null
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public User(){

    }

    public User(Integer id, String name, String sex, Integer age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getId() {
        return id;
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
}
