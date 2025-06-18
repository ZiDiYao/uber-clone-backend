package org.zidi.customer.client.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.zidi.dto.response.CustomerInfoResponse;

@FeignClient(
        name = "service-customer",
        contextId = "customerInfoFeignClient",
        path = "/internal/info"
)
public interface CustomerInfoFeignClient {
    @GetMapping("/getCustomerInfo")
    CustomerInfoResponse getCustomerInfo(@RequestHeader("token") String token);
}
