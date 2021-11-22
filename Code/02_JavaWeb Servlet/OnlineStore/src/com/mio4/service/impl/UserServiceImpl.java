package com.mio4.service.impl;

import com.mio4.dao.IUserDao;
import com.mio4.dao.impl.UserDaoImpl;
import com.mio4.domain.User;
import com.mio4.service.IUserService;
import com.mio4.utils.MailUtils;

import javax.mail.MessagingException;
import java.sql.SQLException;

public class UserServiceImpl implements IUserService {

	/** 用户注册
	 * @param user
	 * @throws SQLException
	 * @throws MessagingException
	 */
	public void regist(User user) throws SQLException, MessagingException {
		IUserDao dao = new UserDaoImpl();
		dao.add(user);

		//发送激活邮件
		String mailMsg = "点击链接激活账号<a href='http://localhost:8080/OnlineStore/user?method=active&code=" + user.getCode() +  "'>点击激活</a>";
		MailUtils.sendMail(user.getEmail(),mailMsg);
	}

	/**
	 * 注册用户激活
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	public User active(String code) throws SQLException {
		IUserDao dao = new UserDaoImpl();

		//1.通过code获取一个用户
		User user = dao.getByCode(code);

		//2.判断用户是否为空
		if(user == null){
			return null;
		}

		//3.修改用户状态state
		//设置用户的状态为1
		user.setState(1);
		dao.update(user);

		return user;
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public User login(String username, String password) throws SQLException {
		IUserDao dao = new UserDaoImpl();
		User user = dao.getByUsernameAndPwd(username,password);
		return user;
	}
}
