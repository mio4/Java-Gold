package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Demo2 {

	/**
	 * 持久态对象有自动更新数据库的能力
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//获取持久态对象
		User user = session.get(User.class,3);
		System.out.println(user.getName());

		user.setName("mio100");
		//session.update(user);

		tr.commit();
		session.close();
	}
}
