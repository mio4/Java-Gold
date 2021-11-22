package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class UpdateTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        User user = sqlSession.selectOne("com.mio4.mapper.UserMapper.selectUser",1);
        user.setName("xxx");
        user.setAge(0);
        sqlSession.update("com.mio4.mapper.UserMapper.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }
}
