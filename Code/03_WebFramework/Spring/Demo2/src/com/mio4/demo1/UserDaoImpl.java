package com.mio4.demo1;

import org.springframework.stereotype.Repository;

/**
 * 将UserDao实现类交给容器管理
 */
@Repository(value="userDao")
public class UserDaoImpl implements UserDao{

	@Override
	public void save() {
		System.out.println("save customer");

	}
}
