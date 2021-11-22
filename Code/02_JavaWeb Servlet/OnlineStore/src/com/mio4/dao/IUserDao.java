package com.mio4.dao;

import com.mio4.domain.User;

import java.sql.SQLException;

public interface IUserDao{
	void add(User user) throws SQLException;

	User getByCode(String code) throws SQLException;

	void update(User user) throws SQLException;

	User getByUsernameAndPwd(String username, String password) throws SQLException;
}
