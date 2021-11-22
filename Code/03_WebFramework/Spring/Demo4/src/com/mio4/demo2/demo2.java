package com.mio4.demo2;

import org.junit.Test;

public class demo2 {

    @Test
    public void test1(){
        BookDaoImpl bookDao = new BookDaoImpl();
        bookDao.save();
        bookDao.update();
        System.out.println("***");
        BookDaoImpl proxy = MyCglibUtils.getProxy();
        proxy.save();
        proxy.update();
    }
}
