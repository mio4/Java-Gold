package com.mio4.mapper;

import com.mio4.domain.User;

import java.util.List;

public interface UserMapper {
    User selectUserById(Integer id);
    List<User> selectAllUser();
    void deleteUserById(Integer id);
    List<User> selectUserByAge(Integer id);
}
