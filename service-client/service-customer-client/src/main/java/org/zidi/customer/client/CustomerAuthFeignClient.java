package org.zidi.customer.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;

@FeignClient(value = "service-customer")
public interface CustomerAuthFeignClient {

    @PostMapping("/customer/info/login")
    CustomerLoginResponse login(@RequestBody CustomerLoginRequest request);
}