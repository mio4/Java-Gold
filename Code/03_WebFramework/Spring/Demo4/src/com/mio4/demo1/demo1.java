package com.mio4.demo1;

import org.junit.Test;

public class demo1 {

    @Test
    public void test1(){
        UserDao userDao = new UserDaoImpl();
        userDao.save();
        userDao.update();
        System.out.println("***");
        UserDao proxy = MyProxyUtils.getProxy(userDao);
        proxy.save();
        proxy.update();
    }
}
