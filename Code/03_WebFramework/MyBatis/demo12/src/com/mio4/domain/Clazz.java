package com.mio4.domain;

import java.io.Serializable;
import java.util.List;

/**
 * CREATE TABLE tb_clazz(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	CODE VARCHAR(20),
 * 	NAME VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Clazz implements Serializable {
    private Integer id;
    private String code;
    private String name;

    private List<Student> student_list;

    public Clazz(){

    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", student_list=" + student_list +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudent_list(List<Student> student_list) {
        this.student_list = student_list;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudent_list() {
        return student_list;
    }
}
