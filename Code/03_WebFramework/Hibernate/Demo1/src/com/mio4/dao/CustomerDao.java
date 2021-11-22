package com.mio4.dao;

import com.mio4.domain.Customer;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CustomerDao {
	/**
	 * 保存一个用户
	 */
	public void addCustomer(Customer c) {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();
		session.close();
	}

	/**
	 * 查询客户
	 * @return
	 */
	public List<Customer> findAll() {
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();

		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();

		transaction.commit();
		session.close();
		return list;
	}
}
