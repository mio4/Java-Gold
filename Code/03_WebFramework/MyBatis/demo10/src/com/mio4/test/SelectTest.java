package com.mio4.test;

import com.mio4.domain.User;
import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class SelectTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        User user = sqlSession.selectOne("com.mio4.mapper.UserMapper.selectUser",1);
        System.out.println(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
