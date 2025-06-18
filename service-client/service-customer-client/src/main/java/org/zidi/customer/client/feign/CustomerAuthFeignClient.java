package org.zidi.customer.client.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;

@FeignClient(
        name = "service-customer", // 注册中心中的服务名
        contextId = "customerAuthFeignClient",
        path = "/internal/auth"    // 对应 Controller 上的 @RequestMapping("/internal/auth")
)
public interface CustomerAuthFeignClient {

    @PostMapping("/login")
    CustomerLoginResponse login(@RequestBody CustomerLoginRequest request);
}
