package com.mio4.mapper;

import com.mio4.domain.User;

public interface UserMapper {
    User selectUserById(int id);
}
