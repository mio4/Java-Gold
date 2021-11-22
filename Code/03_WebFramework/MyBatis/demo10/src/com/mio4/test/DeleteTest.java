package com.mio4.test;

import com.mio4.utils.sessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

public class DeleteTest {
    public static void main(String[] args){
        SqlSession sqlSession = sessionFactoryUtils.getSqlSession();
        sqlSession.delete("com.mio4.mapper.UserMapper.deleteUser",1);
        sqlSession.commit();
        sqlSession.close();
    }
}
