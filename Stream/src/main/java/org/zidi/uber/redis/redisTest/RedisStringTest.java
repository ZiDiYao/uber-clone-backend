package org.zidi.uber.redis.redisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 *
 *
 * 最常用, 可以用于设置 Token, 发送验证码等
 */
@Service
public class RedisStringTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void testString(){
        redisTemplate.opsForValue().set("user","zidi");
        String name = (String)redisTemplate.opsForValue().get("user");
        System.out.println(name);

    }
}
