package com.mio4.test;

import com.mio4.domain.Customer;
import com.mio4.domain.Linkman;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 测试一对多
 */
public class Demo1 {

	/**
	 * 双向关联
	 * 级联保存
	 */
	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCust_name("mio1");
		Linkman l1 = new Linkman();
		l1.setLkm_name("l1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("l2");

		c1.getLinkmans().add(l1);
		c1.getLinkmans().add(l2);
/*		l1.setCustomer(c1);
		l2.setCustomer(c1);*/

		session.save(c1);
/*		session.save(l1);
		session.save(l2);*/

		tr.commit();

	}

	/**
	 * 级联保存：只保存linkman,数据库自动保存customer
	 */
	@Test
	public void test2(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCust_name("mio1");
		Linkman l1 = new Linkman();
		l1.setLkm_name("l1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("l2");


		l1.setCustomer(c1);
		l2.setCustomer(c1);

		session.save(l1);
		//session.save(l2);

		tr.commit();

	}

	/**
	 * 级联保存测试
	 */
	@Test
	public void test3(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCust_name("mio1");
		Linkman l1 = new Linkman();
		l1.setLkm_name("l1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("l2");

		l1.setCustomer(c1);
		c1.getLinkmans().add(l2);
		session.save(l1);

		tr.commit();

	}

	/**
	 * 删除客户（客户下有两个联系人，外键约束）
	 */
	@Test
	public void test4(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = session.get(Customer.class,15L);
		session.delete(c1);

		tr.commit();
	}


	/**
	 * 级联删除
	 * 删除客户，同时删除对应的用户
	 */
	@Test
	public void test5(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = session.get(Customer.class,16L); //serializable为什么是Long？ 数据库中主键是bigint(32)
		session.delete(c1);

		tr.commit();
	}

	/**
	 * 级联删除
	 * 删除联系人，同时删除对应的客户
	 */
	@Test
	public void test6(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Linkman l1 = session.get(Linkman.class,110L);
		session.delete(l1);

		tr.commit();
	}

	/**
	 * 解除关系
	 */
	@Test
	public void test7(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = session.get(Customer.class,19L);
		Linkman l1 = session.get(Linkman.class,112L);
		c1.getLinkmans().remove(l1);
		//c1.getLinkmans().add(l1);

		tr.commit();
	}


	/**
	 * TODO
	 * 放弃对外键的维护
	 */
	@Test
	public void test8(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c2 = session.get(Customer.class, 20L);
		Linkman l1 = session.get(Linkman.class, 116L);

		//双向关联
		c2.getLinkmans().add(l1);
		l1.setCustomer(c2);

		tr.commit();
	}


	/**
	 * inverse属性以及放弃对于外键的维护
	 */
	@Test
	public void test9(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCust_name("mio");
		Linkman l1 = new Linkman();
		l1.setLkm_name("link 1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("link 2");

		c1.getLinkmans().add(l1);
		c1.getLinkmans().add(l2);
		session.save(c1);

		tr.commit();
	}

	/**
	 * 一方：放弃对于外键的维护 inverse = true
	 * 多方：配置级联保存  cascade = save-update
	 */
	@Test
	public void test10(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		Customer c1 = new Customer();
		c1.setCust_name("mio");
		Linkman l1 = new Linkman();
		l1.setLkm_name("link 1");
		Linkman l2 = new Linkman();
		l2.setLkm_name("link 2");

		l1.setCustomer(c1);
		l2.setCustomer(c1);
		session.save(l1);
		session.save(l2);

		tr.commit();
	}






}
