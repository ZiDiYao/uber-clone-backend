package org.zidi.customer.client.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;

@FeignClient("service-customer")
public interface CustomerAuthFeignClient {

    @PostMapping("/internal/auth/login")
    CustomerLoginResponse login(@RequestBody CustomerLoginRequest request);
}
