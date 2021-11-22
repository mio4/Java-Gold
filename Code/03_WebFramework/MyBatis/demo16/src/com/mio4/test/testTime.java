package com.mio4.test;

import com.mio4.domain.Time;
import com.mio4.factory.mySqlSessionFactory;
import com.mio4.mapper.TimeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class testTime {

    @Test
    public void testTime(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        TimeMapper timeMapper = sqlSession.getMapper(TimeMapper.class);


        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Time time = new Time();
        time.setTime(timestamp);
        System.out.println(timestamp);
        timeMapper.saveTime(time);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testTime2(){
        SqlSession sqlSession = mySqlSessionFactory.getSqlSession();
        TimeMapper timeMapper = sqlSession.getMapper(TimeMapper.class);


        List<Time> times = timeMapper.selectAll();
        for(Time t : times){
            System.out.println(t.getTime());
        }

        sqlSession.commit();
        sqlSession.close();
    }
}
