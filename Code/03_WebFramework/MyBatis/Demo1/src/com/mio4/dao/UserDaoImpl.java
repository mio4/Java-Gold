package com.mio4.dao;

import com.mio4.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao{

    private SqlSessionFactory sqlSessionFactory;

    //构造方法注入
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public User findUserById(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById",id);
    }

    @Override
    public List<User> findUserByUsername(String username) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectList("test.findUserByUsername",username);
    }
}
