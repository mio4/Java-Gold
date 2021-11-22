package com.mio4.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext3.xml")
public class demo1 {

    @Resource(name="customerDao")
    private CustomerDao customerDao;

    @Test
    public void test1(){
        customerDao.save();
        //customerDao.save(10);
    }
}
