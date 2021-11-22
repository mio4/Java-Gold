package com.mio4.dao;

import com.mio4.pojo.User;

import java.util.List;

public interface UserDao {

    User findUserById(Integer id);
    List<User> findUserByUsername(String username);

}
