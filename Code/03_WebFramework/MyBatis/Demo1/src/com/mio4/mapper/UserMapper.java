package com.mio4.mapper;

import com.mio4.pojo.User;

import java.util.List;

public interface UserMapper {
    User findUserById(Integer i);
    List<User> findUserByUsername(String username);
}
