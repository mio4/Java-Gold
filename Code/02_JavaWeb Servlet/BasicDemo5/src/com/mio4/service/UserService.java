package com.mio4.service;

import com.mio4.dao.UserDao;
import com.mio4.domain.User;

import java.sql.SQLException;

public class UserService {

	/**
	 * 用户登录方法
	 * @param username 用户名
	 * @param password 密码
	 * @return user用户
	 */
	public static User login(String username, String password) throws SQLException{
		//调用dao
		UserDao dao = new UserDao();
		User user = null;
		try{
			user = dao.getUserByUsernameAndPwd(username,password);
		} catch(Exception e){
			System.out.println("Exception at UserService");
		}
		return user;
	}

	public static int regist(User user){
		UserDao dao = new UserDao();
		return dao.addUser(user);
	}
}
