package com.mio4.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User implements Serializable {
    private String loginname;

    //@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    public User(){
        super();
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

//    public void setBirthday(Date birthday){
//        this.birthday = birthday;
//    }

    public void setBirthday(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try{
            date = sdf.parse(birthday);
            this.birthday = date;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getLoginname() {
        return loginname;
    }

    public Date getBirthday() {
        return birthday;
    }
}
