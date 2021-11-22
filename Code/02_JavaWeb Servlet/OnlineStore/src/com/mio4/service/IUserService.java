package com.mio4.service;

import com.mio4.domain.User;

import javax.mail.MessagingException;
import java.sql.SQLException;

public interface IUserService {
	void regist(User user) throws SQLException, MessagingException;
	User active(String code) throws SQLException;

	User login(String username, String password) throws Exception;
}
