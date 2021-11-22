package com.mio4.demo1;

public class CustomerDaoImpl implements CustomerDao{


    @Override
    public void save() {
        //int i = 1/0;
        System.out.println("save~");
    }

    @Override
    public void update() {
        System.out.println("update~");
    }
}
