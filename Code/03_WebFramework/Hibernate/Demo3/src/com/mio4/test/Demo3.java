package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

public class Demo3 {

	/**
	 * 证明Session一级缓存 存在
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		User user = new User();
		user.setName("mio3");
		user.setAge(203);

		Serializable id = session.save(user); //user被保存到缓存中
		System.out.println("session id " + id);

		//控制台并不会输出SQL语句
		User user2 = session.get(User.class,id);
		System.out.println("从缓存中拿出的" + user2.getName());

		tr.commit();
		session.close();
	}

	/**
	 * 证明Session一级缓存 存在
	 */
	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//只有一条数据库查询语句
		User user1 = session.get(User.class,1);
		System.out.println(user1.getName());

		User user2 = session.get(User.class,1);
		System.out.println(user2.getName());

		tr.commit();
		session.close();
	}

	/**
	 * 快照机制
	 */
	@Test
	public void test3(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		//TODO ...
		tr.commit();
		session.close();
	}
}
