package org.zidi.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zidi.common.util.RedisUtils;
import org.zidi.dto.response.CustomerInfoResponse;
import org.zidi.entity.CustomerInfo;
import org.zidi.mapper.CustomerInfoMapper;
import org.zidi.service.CustomerInfoService;

@Service
@RequiredArgsConstructor
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final RedisUtils redisUtils;
    private final CustomerInfoMapper customerInfoMapper;

    @Override
    public CustomerInfoResponse getCustomerInfo(String token) {
        // Step 1: 根据 Token 提取 userId
        Long userId = extractUserIdFromToken(token);
        if (userId == null) {
            return null;
        }

        // Step 2: 查询数据库，获取用户信息
        CustomerInfo customer = getValidCustomerInfo(userId);
        if (customer == null) {
            return null;
        }

        // Step 3: 封装返回结果
        return buildCustomerInfoResponse(customer);
    }

    /**
     * 从 token 中获取用户 ID，Redis 验证 + 转换
     */
    private Long extractUserIdFromToken(String token) {
        if (token == null || token.isBlank()) {
            return null;
        }

        String key = "user:login:" + token;
        String userIdStr = redisUtils.getValueByKey(key);
        if (userIdStr == null) {
            return null;
        }

        try {
            return Long.parseLong(userIdStr);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * 查询有效的用户对象，排除逻辑删除
     */
    private CustomerInfo getValidCustomerInfo(Long userId) {
        CustomerInfo customer = customerInfoMapper.selectById(userId);
        return (customer != null && customer.getIsDeleted() == 0) ? customer : null;
    }

    /**
     * 封装 CustomerInfo 为 DTO
     */
    private CustomerInfoResponse buildCustomerInfoResponse(CustomerInfo customer) {
        CustomerInfoResponse response = new CustomerInfoResponse();
        response.setUserId(customer.getId());
        response.setNickname(customer.getNickname());
        response.setAvatarUrl(customer.getAvatarUrl());
        response.setGender(customer.getGender());
        response.setPhoneNumber(customer.getPhone());
        response.setStatus(customer.getStatus());
        response.setRegisterTime(
                customer.getCreateTime() != null ? customer.getCreateTime().toString() : null
        );
        return response;
    }
}
