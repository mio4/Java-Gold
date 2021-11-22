package com.mio4.service.impl;

import com.mio4.domain.User;
import com.mio4.mapper.UserMapper;
import com.mio4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *
     * @param loginname 登录名
     * @param password 密码
     * @return
     */
    @Override
    public User login(String loginname, String password) {
        return userMapper.findWithLoginnameAndPassword(loginname,password);
    }
}
