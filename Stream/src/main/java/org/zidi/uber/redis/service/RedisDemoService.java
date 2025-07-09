package org.zidi.uber.redis.service;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.zidi.uber.redis.Serializable.User;

@Service
public class RedisDemoService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public void testRedis() {
        String key = "hello";
        User value = new User(1L,"zidi");

        // 存入 Redis
        redisTemplate.opsForValue().set(key, value);
        System.out.println("写入 Redis: " + key + " -> " + value);

        // 从 Redis 读取
        Object result = redisTemplate.opsForValue().get(key);
        System.out.println("读取 Redis: " + key + " -> " + result);
    }
}
