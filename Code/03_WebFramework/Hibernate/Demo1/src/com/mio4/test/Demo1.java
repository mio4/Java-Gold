package com.mio4.test;

import com.mio4.domain.Customer;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;


/**
 * 测试Hibernate框架
 */
public class Demo1 {

	/**
	 * 测试保存一个客户到数据库
	 */
	@Test
	public void testSave(){
		//1.加载配置文件
		Configuration config = new Configuration();
		config.configure(); //默认加载src下的hibernate.cfg.xml文件
		//2.创建SessionFactory对象
		SessionFactory factory = config.buildSessionFactory();
		//3.创建Session对象
		Session session = factory.openSession();
		//4.开启事务
		Transaction transaction = session.beginTransaction();
		//5.编写保存代码
		Customer customer = new Customer();
		customer.setCust_name("test_name2");
		customer.setCust_level("1");
		session.save(customer);
		//6.提交事务
		transaction.commit();
		//7.释放资源
		session.close();
	}

	/**
	 * 测试工具类
	 */
	@Test
	public void testSave2(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Customer c = new Customer();
		c.setCust_name("mio");
		session.save(c);
		transaction.commit();
		session.close();
	}


	/**
	 * session.get()
	 * 通过主键查询一条记录
	 */
	@Test
	public void testGet(){
		Session session = HibernateUtils.getSession();
		Customer c = session.get(Customer.class,4L);
		if(c != null)
			System.out.println(c.toString());
		session.close();
	}


	/**
	 * session.delete()
	 * 删除之前需要查询，保证有这个对象
	 */
	@Test
	public void testDelete(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Customer c = session.get(Customer.class,4L);
		session.delete(c);
		transaction.commit();
		session.close();
	}

	/**
	 * session.update()
	 * 测试修改,对于查询出来的对象
	 */
	@Test
	public void testUpdate(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Customer c = session.get(Customer.class,3L);
		c.setCust_name("mio");
		session.update(c);
		transaction.commit();
		session.close();
	}


	/**
	 * 测试添加和修改用户
	 */
	@Test
	public void testSaveOrUpdate(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Customer c = new Customer();
		c.setCust_name("mio2");
		//主键不能随意设置
		//c.setCust_id(10L);
		session.saveOrUpdate(c);
		transaction.commit();
		session.close();
	}


	/**
	 * session.createQuery()
	 * 查询
	 */
	@Test
	public void testQuery(){
		Session session = HibernateUtils.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Customer");
		List<Customer> list = query.list();
		for(Customer c : list){
			System.out.println(c.toString());
		}
		transaction.commit();
		session.close();
	}


	/**
	 * 开启事务，提交事务
	 */
	@Test
	public void testSave3(){
		Session session = null;
		Transaction transaction = null;
		try{
			session = HibernateUtils.getSession();
			transaction = session.beginTransaction();
			Customer c = new Customer();
			c.setCust_name("mio4");
			session.save(c);
			transaction.commit();

		} catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		} finally{

		}
	}


}
