package org.zidi.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zidi.dto.response.CustomerInfoResponse;
import org.zidi.entity.CustomerInfo;
import org.zidi.mapper.CustomerInfoMapper;
import org.zidi.service.CustomerInfoService;
import org.zidi.uber.common.auth.TokenService;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerInfoServiceImpl implements CustomerInfoService {

    private final TokenService tokenService;  // Abstract
    private final CustomerInfoMapper customerInfoMapper;

    @Override
    public CustomerInfoResponse getCustomerInfo(String token) {
        Long userId = extractUserIdFromToken(token);
        if (userId == null) return null;

        CustomerInfo customer = getValidCustomerInfo(userId);
        if (customer == null) return null;

        return buildCustomerInfoResponse(customer);
    }

    private Long extractUserIdFromToken(String token) {
        return tokenService.getUserIdByToken(token);
    }

    private CustomerInfo getValidCustomerInfo(Long userId) {
        CustomerInfo customer = customerInfoMapper.selectById(userId);
        return (customer != null && customer.getIsDeleted() == 0) ? customer : null;
    }

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
