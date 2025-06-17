package org.zidi.customer.feign;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zidi.dto.request.CustomerLoginRequest;
import org.zidi.dto.response.CustomerLoginResponse;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerAuthFeignClient {

    private final org.zidi.customer.client.feign.CustomerAuthFeignClient customerAuthFeignClient;

    @PostMapping("/login")
    public CustomerLoginResponse login(@RequestBody CustomerLoginRequest request) {
        return customerAuthFeignClient.login(request);  // Feign 调用 service-customer
    }


}
