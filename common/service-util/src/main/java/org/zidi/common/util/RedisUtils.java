package org.zidi.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 通过 key 获取对应的 value
     * @param key Redis 的键
     * @return 如果 key 存在则返回对应的值，否则返回 null
     */
    public String getValueByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
