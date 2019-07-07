package com.atguigu.artcrowdfundinguser;

import com.atguigu.user.dao.TMemberMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtcrowdfundingUserApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Autowired
    TMemberMapper memberMapper;
    @Test
    public void testMapper(){


        long count = memberMapper.countByExample(null);
        System.out.println("统计结果："+count);
    }
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void testStringRedisTemplate(){
        ValueOperations<String, String> value = stringRedisTemplate.opsForValue();
        value.append("msg","hello");

    }



}
