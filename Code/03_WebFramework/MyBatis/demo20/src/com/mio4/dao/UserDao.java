package com.mio4.dao;

import com.mio4.dao.provider.UserDynSqlProvider;
import com.mio4.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

import static com.mio4.util.common.HrmConstants.USERTABLE;

public interface UserDao {

    //根据用户名和密码查询员工
    @Select("select * from " + USERTABLE + "where loginname = #{loginanme} and password = #{password}")
    User selectByLoginnameAndPassword(@Param("loginname") String loginname,
                                      @Param("password") String password);
    //根据id查询员工
    @Select("select * from " + USERTABLE + "where id = #{id}")
    User selectUserById(@Param("id") Integer id);

    //根据id删除用户
    @Delete("delete from" + USERTABLE + " where id = #{id}")
    void deleteById(Integer id);

    //分页动态查询
    @SelectProvider(type = UserDynSqlProvider.class,method = "selectWithParam")
    List<User> selectByPage(Map<String,Object> params);

    //动态修改用户
    @UpdateProvider(type =  UserDynSqlProvider.class, method = "updateUser")
    void update(User user);

    //根据参数查询用户总数
    @SelectProvider(type = UserDynSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    //动态插入用户
    @InsertProvider(type = UserDynSqlProvider.class,method = "insertUser")
    void save(User user);

}
