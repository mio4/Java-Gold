package com.mio4.domain;

import java.io.Serializable;

/**
 *CREATE TABLE job_inf (
 *   ID INT(11) NOT NULL AUTO_INCREMENT,
 *   NAME VARCHAR(50) NOT NULL,
 *   REMARK VARCHAR(300) DEFAULT NULL,
 *   PRIMARY KEY (ID)
 * ) ENGINE=INNODB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
 */
public class Job implements Serializable {
    private Integer id;
    private String name;
    private String remark;

    public Job(){

    }

    @Override
    public String toString() {
        return "Job{" +
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

