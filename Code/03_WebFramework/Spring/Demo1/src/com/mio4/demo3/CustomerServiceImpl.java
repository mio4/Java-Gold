package com.mio4.demo3;

public class CustomerServiceImpl {

	/**
	 *
	 */
	private CustomerDaoImpl customerDao;
	public void setCustomerDao(CustomerDaoImpl customerDao){
		this.customerDao = customerDao;
	}

	public void save(){
		System.out.println("service:save customer");
		//原生方式
		//new CustomerDaoImpl().save();

		//依赖注入
		customerDao.save();
	}
}
