package com.mio4.domain;

import java.sql.Timestamp;

public class Time {
    private Integer id;
    private Timestamp Time;


    public Time(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return Time;
    }

    public void setTime(Timestamp time) {
        Time = time;
    }
}
