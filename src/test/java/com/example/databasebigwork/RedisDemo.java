package com.example.databasebigwork;


import com.example.databasebigwork.utils.IdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisDemo {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void redisTest(){
        redisTemplate.opsForValue().set("age","12");
        String age = redisTemplate.opsForValue().get("age");
        System.out.println(age);
    }

    @Autowired
    IdGenerator idGenerator;

    @Test
    public void idTest(){
        for (int i = 0; i < 100; i++) {
            System.out.println(i+"id:"+idGenerator.incrementID(0));
        }
        redisTemplate.opsForValue().set("id:user","0");

    }

    @Test
    public void test1(){
        Long id = 123L;
        System.out.println(String.format("%012d", id));
    }

}
