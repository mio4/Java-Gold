package com.mio4.test;

import com.mio4.domain.Person;
import com.mio4.factory.mySqlSessionFactory;
import com.mio4.mapper.PersonMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class testOneToOne {


    @Test
    public void OneToOne(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        PersonMapper personMapper = sqlSession.getMapper(PersonMapper.class);
        Person person = personMapper.selectPersonById(1);
        System.out.println(person);
        System.out.println(person.getCard());

        sqlSession.commit();
        sqlSession.close();
    }
}
