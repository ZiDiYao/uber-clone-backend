package org.zidi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.annotation.Log;
import org.zidi.dto.response.CustomerInfoResponse;
import org.zidi.service.CustomerInfoService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/info")
public class CustomerInfoController {

    private final CustomerInfoService customerInfoService;

//    @Log(module = "service-customer", operation = "getCustomerInfo")
    @GetMapping("/getCustomerInfo")
    public CustomerInfoResponse getCustomerInfo(@RequestHeader(value = "token", defaultValue = "") String token) {
        // 你可以选择抛出异常，或返回 null（不推荐）
        // throw new RuntimeException("用户不存在或未登录");
        return customerInfoService.getCustomerInfo(token);
    }
}
