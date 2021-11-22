package com.mio4.dao;

import com.mio4.domain.User;
import com.mio4.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDao {

	/**
	 *
	 * @param username
	 * @param password
	 * @return
	 */
	public User getUserByUsernameAndPwd(String username,String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		User user = null;
		try {
			user = qr.query(sql, new BeanHandler<>(User.class), username, password);
		} catch(Exception e){
			System.out.println("Exception at UserDao");
		}
		return user;
	}

	/**
	 * 注册用户
	 * @param user 用户
	 * @return 注册是否成功
	 */
	public int addUser(User user){
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user(username,password,email,name,sex,birthday,hobby) values(?,?,?,?,?,?,?)";
		try{
			return qr.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),
					user.getName(),user.getSex(),user.getBirthday(),
					user.getHobby());
		} catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
