package com.mio4.dao;

import com.mio4.domain.User;
import com.mio4.utils.HibernateUtils;
import org.hibernate.Session;

public class UserDao {

	public void save1(User user1){
		Session session = HibernateUtils.getCurrentSession();
		session.save(user1);
	}

	public void save2(User user2){
		Session session = HibernateUtils.getCurrentSession();
		session.save(user2);
	}

}
