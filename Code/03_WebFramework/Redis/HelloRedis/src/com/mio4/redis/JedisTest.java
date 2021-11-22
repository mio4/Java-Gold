package com.mio4.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

    /**
     * 远程连接Linux上的Redis
     * 【将Host和Port暴露不安全】
     */
    @Test
    public void test1(){
        Jedis jedis = new Jedis("39.105.222.221",6379); //创建连接
        jedis.set("key2","2");
        System.out.println(jedis.get("key2"));
    }

    /**
     * test Jedis Pool
     */
    @Test
    public void test2(){
        JedisPool jedisPool = new JedisPool("39.105.222.221",6379); //创建连接池
        Jedis jedis = jedisPool.getResource();
        jedis.set("key3","java");
        System.out.println(jedis.get("key3"));
        jedis.close();
    }
}
