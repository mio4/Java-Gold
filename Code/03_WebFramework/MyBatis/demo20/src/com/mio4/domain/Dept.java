package com.mio4.domain;

import java.io.Serializable;

/**
 * CREATE TABLE dept_inf (
 *   ID INT(11) NOT NULL AUTO_INCREMENT,
 *   NAME VARCHAR(50) NOT NULL,
 *   REMARK VARCHAR(300) DEFAULT NULL,
 *   PRIMARY KEY (ID)
 * ) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
 */
public class Dept implements Serializable {
    private Integer id;
    private String name;
    private String remark;

    public Dept(){

    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRemark() {
        return remark;
    }
}
