package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Demo4 {

	/**
	 * 清空Session缓存
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user1 = session.get(User.class,1);
		System.out.println(user1.getName());

		//清空缓存
		session.clear();

		User user2 = session.get(User.class,1);
		System.out.println(user2.getName());

		tr.commit();
		session.close();
	}

	/**
	 * session.evict()
	 */
	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user1 = session.get(User.class,1);
		System.out.println(user1.getName());

		//清空user1
		session.evict(user1);

		User user2 = session.get(User.class,1);
		System.out.println(user2.getName());

		tr.commit();
		session.close();
	}

	/**
	 *
	 */
	@Test
	public void test3(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user1 = session.get(User.class,1);
		user1.setName("mioooo");

		//自动刷新
		session.flush();


		tr.commit();
		session.close();
	}
}
