package org.zidi.uber.redis.redisTest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 *
 * Hash 是一种非常节省内存的方式，适合存用户详情、配置信息等
 * 把用户信息（如 id、name、role 等）放到 Redis 的 Hash 结构中
 * 当高并发访问某个数据时（比如某一页爆红的商品详情页），数据库容易被打爆
 * 查询用户资料先查 Redis；
 * 查不到再查数据库，并回写到 Redis；
 * 设置 TTL，定期刷新缓存。
 */
@Service
public class RedisHashTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void addUserHash(){
        String key = "user:1001";
        redisTemplate.opsForHash().put(key,"name","zidi");
        redisTemplate.opsForHash().put(key, "age", 23);
        redisTemplate.opsForHash().put(key, "gender", "male");
    }

    public void getUserName(){
        String name = (String)redisTemplate.opsForHash().get("key","name");
        System.out.println("name"+name);
    }

    public void getAllUserInfo(){

        Map<Object, Object> userInfo = redisTemplate.opsForHash().entries("user:1001");
        userInfo.forEach((k,v)-> System.out.println("k:" + k + ":"+ v));
    }

}
