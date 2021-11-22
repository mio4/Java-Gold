package com.mio4.domain;

import java.util.List;

/**
 * CREATE TABLE TB_CLAZZ(
 * 	id INT PRIMARY KEY AUTO_INCREMENT,
 * 	CODE VARCHAR(20)
 * )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class Clazz {
    private Integer id;
    private String code;

    //添加Student集合对象
    private List<Student> students;

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public List<Student> getStudents() {
        return students;
    }
}
