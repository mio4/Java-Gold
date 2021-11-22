package com.mio4.mapper;

import com.mio4.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("INSERT INTO TB_USER(name,age,sex) VALUES (#{name},#{age},#{sex})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int saveUser(User user);

    @Delete("DELETE FROM TB_USER WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE TB_USER SET name = #{name},sex = #{sex}, age = #{age} WHERE id = #{id}")
    void modifyUser(User user);

    @Select("SELECT * FROM TB_USER WHERE id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age",column = "age")
    })
    User selectUserById(Integer id);

    @Select("SELECT * FROM TB_USER")
    List<User> selectAllUser();
}
