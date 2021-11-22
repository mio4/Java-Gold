package com.mio4.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisSpringTest {
    private ApplicationContext appllicationContext;
    private String configLocation = "classpath:ApplicationContext.xml";

    @Before
    public void setUp() throws Exception{
        appllicationContext = new ClassPathXmlApplicationContext(configLocation);
    }

    @Test
    public void testSpringJedis(){
        JedisPool jedisPool = (JedisPool) appllicationContext.getBean("jedisPool");
        Jedis jedis = jedisPool.getResource();
        System.out.println(jedis.get("key3"));
        jedis.close();
    }
}
