package com.mio4.test;

import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Criteria接口
 */
public class Demo7 {

	@Test
	public void test1(){
		Session session = HibernateUtils.getSession();
		Transaction tr = session.beginTransaction();

		//TODO
		//session.createCriteria();

		tr.commit();
		session.close();
	}
}
