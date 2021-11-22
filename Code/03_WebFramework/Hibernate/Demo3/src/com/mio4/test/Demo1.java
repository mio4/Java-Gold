package com.mio4.test;

import com.mio4.domain.Person;
import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.io.Serializable;

public class Demo1 {

	/**
	 * 测试主键生成策略increment
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		User user = new User();
		user.setAge(20);
		session.save(user);
		tr.commit();
		session.close();
	}


	/**
	 * 测试主键生成策略uuid
	 */
	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		Person person = new Person();
		person.setPname("mio");
		person.setPid("1");
		session.save(person);
		tr.commit();
		session.close();
	}

	/**
	 * 测试持久化对象的状态
	 * Crtl+q 查看方法返回值
	 */
	@Test
	public void test3(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();
		User user = new User();
		user.setName("mio4");
		user.setAge(100);
		//---截至到目前，user是瞬时态---

		Serializable id = session.save(user);
		System.out.println("before session close " + id);
		//---截至到目前，user对象已经有OID的值---

		tr.commit();
		session.close();
		//---截至到目前---
		System.out.println("after session close " + user.getId());
		System.out.println("after session close " + user.getName());
	}
}
