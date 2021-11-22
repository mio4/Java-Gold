package com.mio4.mapper;

import com.mio4.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository(value = "userMapper")
public interface UserMapper {

    @Select("SELECT * FROM TB_USER WHERE loginname = #{loginname} AND password = #{password}")
    User findWithLoginnameAndPassword(@Param("loginname") String loginname,
                                      @Param("password") String password);
}
