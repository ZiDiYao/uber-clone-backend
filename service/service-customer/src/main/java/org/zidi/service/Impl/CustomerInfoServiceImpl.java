package org.zidi.service.Impl;

import lombok.RequiredArgsConstructor;
import me.chanjar.weixin.common.annotation.Required;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.zidi.dto.request.CustomerInfoRequest;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerInfoResponse;
import org.zidi.entity.CustomerInfo;
import org.zidi.mapper.CustomerInfoMapper;
import org.zidi.service.CustomerInfoService;

@RequiredArgsConstructor
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final RedisTemplate<String, String> redisTemplate;


    @Override
    public CustomerInfoResponse getCustomerInfo(CustomerInfoRequest customerLoginRequest) {

        // 第 0 步, 查询是否登录, 如果没有登录, 则提示请登录

        if (!searchedByRedisToken(customerLoginRequest)){
            // means it does not exit
            return null;
        }

        // 使用 Redis

        // 第一步, 根据用户 Token 查询我们的 ID CustomerLogin 中就一个 Token

        // 根据 Redis Token 得到 UserID

        String currToken = customerLoginRequest.getToken();

        // 使用 MySQL 查询

        String userId = "111";

//        CustomerInfo user = CustomerInfoMapper.selectById(userId);

        // 第二步, 把数据分装进 CustomerInfoResponse DTO 中

        CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse();


        // 第三步, 返回

        return null;
    }

    private boolean searchedByRedisToken(CustomerInfoRequest customerLoginRequest){
        String token = customerLoginRequest.getToken();
        if (token == null || token.isBlank()) {
            return false;
        }

        String key = "user:login:" + token; // key 名字视你登录时的设定而定
        String userId = redisTemplate.opsForValue().get(key);

        return userId != null; // Redis 查到了说明有效

    }

}
