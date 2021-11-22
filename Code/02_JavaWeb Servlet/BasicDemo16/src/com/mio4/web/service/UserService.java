package com.mio4.web.service;

import com.mio4.web.dao.UserDao;
import com.mio4.web.domain.User;

import java.sql.SQLException;

public class UserService {

	public User login(String username, String password) throws SQLException {
		return new UserDao().login(username,password);
	}
}
