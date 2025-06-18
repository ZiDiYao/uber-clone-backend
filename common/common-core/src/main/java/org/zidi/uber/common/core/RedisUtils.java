package org.zidi.uber.common.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import java.time.Duration;

@Component
//@RequiredArgsConstructor
public class RedisUtils {

    private final StringRedisTemplate redisTemplate;

    public RedisUtils(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置值
     */
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置值并指定过期时间（单位：秒）
     */
    public void setValue(String key, String value, long seconds) {
        redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(seconds));
    }

    /**
     * 获取值
     */
    public String getValueByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 删除 key
     */
    public void deleteKey(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 判断 key 是否存在
     */
    public boolean hasKey(String key) {
        Boolean hasKey = redisTemplate.hasKey(key);
        return Boolean.TRUE.equals(hasKey);
    }
}