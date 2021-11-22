package com.mio4.service;

import com.mio4.domain.User;

public interface UserService {
    /**
     *
     * @param loginname 登录名
     * @param password 密码
     * @return 找到则返回User对象，否则返回null
     */
    User login(String loginname, String password);
}
