package com.mio4.demo.springboottransaction.service;

import com.mio4.demo.springboottransaction.domain.User;
import com.mio4.demo.springboottransaction.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mio4
 * @date 2020-08-21 09:55
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user){

    }

    public void insertUserWithException(User user){

    }
}
