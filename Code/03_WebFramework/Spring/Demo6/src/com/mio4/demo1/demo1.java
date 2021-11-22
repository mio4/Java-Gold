package com.mio4.demo1;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JDBC Template
 */
public class demo1 {

    @Test
    public void test1(){
        //Spring自带连接池
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///spring");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123456");

        //创建模板类
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(driverManagerDataSource);

        //CRUD操作
        String sql = "insert into t_account values(null,?,?)";
        jdbcTemplate.update(sql,"mio",100.0);
    }

}
