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
import java.util.Map;

public class DynamicSQLTest {


    /**
     * 注解方式
     * 根据动态参数查询员工数据
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Map<String,Object> param = new HashMap<String,Object>();
        param.put("loginname","jack");
        param.put("password",123456);
        List<Employee> employee_list = employeeMapper.selectWithParams(param);
        for(Employee employee : employee_list){
            System.out.println(employee);
        }


        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * 动态添加员工
     */
    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee e = new Employee();
        e.setLoginname("henry");
        e.setAge(1000);
        employeeMapper.insertEmployee(e);

        sqlSession.commit();
        sqlSession.close();
    }









}
