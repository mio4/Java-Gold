package com.mio4.service;

import com.mio4.dao.UserDao;
import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserService {

	public void save(User user1, User user2){
		UserDao dao = new UserDao();

		//获取session
		Session session = HibernateUtils.getCurrentSession();
		Transaction tr = null;
		try {
			//开启事务
			tr = session.beginTransaction();
			dao.save1(user1);
			//模拟中断
			int a = 1/0;
			dao.save1(user2);
			//提交事务
			tr.commit();
		} catch(Exception e){
			e.printStackTrace();
			tr.rollback();
		} finally{
			//不需要手动关闭session
		}
	}
}
