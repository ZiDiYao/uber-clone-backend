package org.zidi.uber.redis.redisTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.zidi.uber.redis.Serializable.User;

@Service
public class redisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void saveUser(){

        User user = new User(1L, "zidi");
        redisTemplate.opsForValue().set("user01",user);
        Object obj = redisTemplate.opsForValue().get("user:1");
        if (obj instanceof User user01) {
            System.out.println(user01.getName());
        } else {
            System.out.println("类型错误！");
        }

    }
}
