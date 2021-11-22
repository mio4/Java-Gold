package com.mio4.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private String loginname;
    private String password;

    public User(){

    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public String getPassword() {
        return password;
    }
}
