package com.mio4.service;

import com.mio4.dao.CustomerDao;
import com.mio4.domain.Customer;

import java.util.List;

public class CustomerService {

	/**
	 * 添加客户
	 * @param c
	 */
	public void addCustomer(Customer c) {
		new CustomerDao().addCustomer(c);
	}


	/**
	 * 查询所有的客户
	 * @return
	 */
	public List<Customer> findAll(){
		return new CustomerDao().findAll();
	}
}
