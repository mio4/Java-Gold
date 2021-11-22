package com.mio4.test;

import com.mio4.domain.Employee;
import com.mio4.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class DynamicSQLTest {

    /**
     * 测试动态SQL中的if语句
     * @throws IOException
     */
    @Test
    public void Test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String,Object> params = new HashMap<String,Object>();
        //params.put("id",5);
        params.put("password","123456");
        params.put("loginname","jack");
        List<Employee> employees = employeeMapper.selectEmployeeByIdLike(params);
        for(Employee e : employees){
            System.out.println(e);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试动态SQL中的choose语句
     * @throws IOException
     */
    @Test
    public void test2() throws IOException{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String,Object> params = new HashMap<String,Object>();
        //params.put("id",1);
        //params.put("loginname","jack");
        // params.put("password","123456");
        List<Employee> employees = employeeMapper.selectEmployeeChoose(params);
        for(Employee e : employees){
            System.out.println(e);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 测试动态SQL中的set
     * @throws Exception
     */
    @Test
    public void test3() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.selectEmployeeWithId(4);
        employee.setName("Marrrrry");
        employee.setAge(9999);
        employeeMapper.updateEmployeeIfNecessary(employee);
        sqlSession.commit();
        sqlSession.close();
    }

}
