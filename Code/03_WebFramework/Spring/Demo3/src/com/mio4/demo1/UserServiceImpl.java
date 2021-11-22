package com.mio4.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component(value="userServiceImpl")
public class UserServiceImpl implements UserService {

    @Value(value="mio")
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    //@Autowired
    //@Qualifier(value="userDao")
    @Resource(name="userDao")
    private UserDao userDao;

    public void sayHello(){
        System.out.println("Hello! " + this.name);
        userDao.save();
    }

    /**
     * 初始化：注解
     */
    @PostConstruct
    public void init(){
        System.out.println("init~");
    }
}
