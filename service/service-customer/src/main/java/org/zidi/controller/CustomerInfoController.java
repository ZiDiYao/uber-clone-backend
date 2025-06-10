package org.zidi.controller;

import com.alibaba.nacos.api.model.v2.Result;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zidi.service.CustomerAuthService;
//import org.zidi.common.Result; // 使用你自己的通用返回类

@RestController
@Slf4j
@RequestMapping("/customer/info")
public class CustomerInfoController {

    @Autowired
    private CustomerAuthService customerInfoService;
    @GetMapping("/login/{code}")
    public Result<Long> login(@PathVariable String code) throws WxErrorException {
//        log.info("收到登录请求，code = {}", code);
//        Long userId = (Long) customerInfoService.login(code);
//        log.info("登录成功，返回用户ID = {}", userId);
//        return Result.success(userId);
        return null;
    }
}
