package com.mio4.dao.impl;

import com.mio4.dao.IUserDao;
import com.mio4.domain.User;
import com.mio4.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.management.Query;
import java.sql.SQLException;

/**
 * CREATE TABLE `user` (
 *   `uid` varchar(32) NOT NULL,
 *   `username` varchar(20) DEFAULT NULL,
 *   `password` varchar(100) DEFAULT NULL,
 *   `name` varchar(20) DEFAULT NULL,
 *   `email` varchar(30) DEFAULT NULL,
 *   `telephone` varchar(20) DEFAULT NULL,
 *   `birthday` varchar(20) DEFAULT NULL,
 *   `sex` varchar(10) DEFAULT NULL,
 *   `state` int(11) DEFAULT NULL,
 *   `code` varchar(64) DEFAULT NULL,
 *   PRIMARY KEY (`uid`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 */
public class UserDaoImpl implements IUserDao {

	/**
	 * 注册新用户
	 * @param user
	 */
	@Override
	public void add(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
		qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),
				user.getName(),user.getEmail(),user.getTelephone(),
				user.getBirthday(),user.getSex(),user.getState(),user.getCode()
		);

	}

	/**
	 * 通过激活码获取一个User
	 * @param code
	 * @return
	 * @throws SQLException
	 */
	@Override
	public User getByCode(String code) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where code = ?";
		return qr.query(sql,new BeanHandler<>(User.class),code);
	}

	/**
	 * 修改用户属性
	 * @param user
	 * @throws SQLException
	 */
	@Override
	public void update(User user) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update user set username=?,password=?,name=?,email=?,telephone=?,birthday=?,state=? where uid=?";
		qr.update(sql,user.getUsername(),user.getPassword(),user.getName(),
				user.getEmail(),user.getTelephone(),user.getBirthday(),
				user.getState(),user.getUid()
				);
	}

	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User getByUsernameAndPwd(String username, String password) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		return qr.query(sql, new BeanHandler<>(User.class),username,password);
	}
}
