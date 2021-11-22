package com.mio4.test;

import com.mio4.domain.Article;
import com.mio4.domain.Order;
import com.mio4.domain.User;
import com.mio4.mapper.OrderMapper;
import com.mio4.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 如果查询不到结果：
 * 1. 数据库原本的数据结构是否正确
 * 2. select语句是否符合逻辑
 * 3. mapper配置传参是否完整|正确
 * 4. 对于tb_user和tb_order的主键都是id，将tb_order的主键id as oid的方式取别名
 */
public class OneToManyTest {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //test
        //testSelectUserById(sqlSession);
        testSelectOrderById(sqlSession);

        sqlSession.commit();
        sqlSession.close();
    }

    public static void testSelectUserById(SqlSession sqlSession){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUserById(1);
        System.out.println(user.getUsername() + " " + user.getId());
        List<Order> orders= user.getOrders();
        for(Order order : orders){
            System.out.println(orders);
        }
    }

    public static void testSelectOrderById(SqlSession sqlSession){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectOrderById(1);
        System.out.println(order);
        List<Article> articles = order.getArticles();
        for(Article article : articles){
            System.out.println(article);
        }
    }
}
