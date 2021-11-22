package com.mio4.domain;

/**
 * CREATE TABLE TB_USER2(
 * 	user_id INT PRIMARY KEY AUTO_INCREMENT,
 * 	user_name VARCHAR(20),
 * 	user_sex VARCHAR(20),
 * 	user_age INT
 * );
 */
public class User2 {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public User2(){

    }

    @Override
    public String toString() {
        return "User2{" +
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
