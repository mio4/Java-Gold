package com.mio4.web.service;

import com.mio4.web.dao.UserDao;
import com.mio4.web.domain.User;

import java.sql.SQLException;

public class UserService {

	/**
	 * 检测用户名是否被占用
	 * @param username
	 * @return
	 */
	public User checkUsername4Ajax(String username) throws SQLException {
		return new UserDao().getUserByUsername4Ajax(username);
	}
}
