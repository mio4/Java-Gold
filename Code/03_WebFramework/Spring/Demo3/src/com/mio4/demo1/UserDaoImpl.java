package com.mio4.demo1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component(value="userDa0")
@Repository(value="userDao")
public class UserDaoImpl implements UserDao{
    public void save(){
        System.out.println("save...");
    }
}
