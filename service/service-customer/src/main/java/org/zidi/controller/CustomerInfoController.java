package org.zidi.controller;

import com.alibaba.nacos.api.model.v2.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.dto.response.CustomerInfoResponse;
import org.zidi.service.CustomerInfoService;
import org.zidi.uber.customer.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/info")
public class CustomerInfoController {

    private final CustomerInfoService customerInfoService;

    @GetMapping("/getCustomerInfo")
    public ApiResponse<CustomerInfoResponse> getCustomerInfo(@RequestHeader(value ="token", defaultValue = "") String token) {
        CustomerInfoResponse response = customerInfoService.getCustomerInfo(token);
        if (response == null) {
            return ApiResponse.fail("The user does not exits or did not sign in");
        }

        return ApiResponse.ok(response);
    }
}
