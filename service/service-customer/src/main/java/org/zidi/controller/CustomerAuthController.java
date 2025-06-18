package org.zidi.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.annotation.Log;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;
import org.zidi.service.CustomerAuthService;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/internal/auth")
public class CustomerAuthController {

    private final CustomerAuthService customerInfoService;

    @Log(module = "service-customer", operation = "login")
    @PostMapping("/login")
    public CustomerLoginResponse login(@RequestBody CustomerLoginRequest request) throws WxErrorException {
        return customerInfoService.login(request);
    }
}
