package org.zidi.uber.common.auth.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zidi.uber.common.auth.TokenService;
import org.zidi.uber.common.core.RedisUtils;

import java.util.UUID;

@Service
public class RedisTokenServiceImpl implements TokenService {

    private final RedisUtils redisUtils;

    @Autowired
    public RedisTokenServiceImpl(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    private static final String PREFIX = "user:login:";

    @Override
    public Long getUserIdByToken(String token) {
        if (token == null || token.isBlank()) return null;
        String value = redisUtils.getValueByKey(PREFIX + token);
        if (value == null) return null;
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String generateToken(Long userId) {
        String token = UUID.randomUUID().toString(); // 或自定义生成规则
        String redisKey = "user:login:" + token;
        redisUtils.setValue(redisKey, userId.toString(), 7 * 24 * 60 * 60); // 有效期 7 天（秒）
        return token;
    }


    @Override
    public void saveToken(String token, Long userId) {
        redisUtils.setValue(PREFIX + token, userId.toString(), 7 * 24 * 60 * 60); // 7天有效
    }

    @Override
    public void removeToken(String token) {
        redisUtils.deleteKey(PREFIX + token);
    }
}
