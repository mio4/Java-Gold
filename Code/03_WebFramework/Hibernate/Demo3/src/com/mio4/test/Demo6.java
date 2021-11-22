package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * 测试Hibernate下的查询
 */
public class Demo6 {

	/**
	 * 条件查询
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//使用JPA-style的查询语句
		Query query = session.createQuery("from User where age > ?0");
		query.setInteger(0,100);
		List<User> list = query.list();

		for(User user : list){
			System.out.println(user.getName());
		}

		tr.commit();
		session.close();
	}

	/**
	 * 模糊查询
	 */
	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Query query = session.createQuery("from User where name like ?0");
		query.setString(0,"mio1%");
		List<User> list = query.list();

		for(User user : list){
			System.out.println(user.getName());
		}

		tr.commit();
		session.close();
	}
}
