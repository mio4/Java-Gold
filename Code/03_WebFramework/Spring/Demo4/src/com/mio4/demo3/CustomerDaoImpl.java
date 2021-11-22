package com.mio4.demo3;

//import org.springframework.stereotype.Component;

//@Component("customerDaoImpl")
public class CustomerDaoImpl implements CustomerDao{

    @Override
    public void save() {
        //模拟异常产生
        //int a = 1/0;
        System.out.println("save customer~");
    }

    @Override
    public void update() {
        System.out.println("update customer~");
    }

    public void save(int i){
        System.out.println("save customer id " + i);
    }
}
