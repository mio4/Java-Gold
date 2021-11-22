package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 从这个例子开始测试事务
 */
public class Demo5 {

	/**
	 * test1和test2测试冲突线程
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//
		User user = session.get(User.class,1);
		user.setName("mio100");

		tr.commit();
		session.close();
	}

	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//
		User user = session.get(User.class,1);
		user.setAge(100);

		tr.commit();
		session.close();
	}
}
