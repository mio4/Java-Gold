package org.fkit.service;

import org.fkit.domain.User;

/**
 * User服务层接口
 * */
public interface UserService {
	
	/**
	 * 判断用户登录
	 * @param String loginname
	 * @param String password
	 * @return 找到返回User对象，没有找到返回null
	 * */
	User login(String loginname,String password);

}
