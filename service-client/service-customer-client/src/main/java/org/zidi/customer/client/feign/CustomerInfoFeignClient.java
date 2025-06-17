package org.zidi.customer.client.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.zidi.dto.response.CustomerInfoResponse;
import org.zidi.uber.customer.ApiResponse;

@FeignClient(
        name = "service-customer", // 提供服务的 module 名（注册中心中的服务名）
        contextId = "customerInfoFeignClient",
        path = "/internal/info"    // 这个是 controller 上的 @RequestMapping 前缀
)
public interface CustomerInfoFeignClient {

    @GetMapping("/getCustomerInfo")
    ApiResponse<CustomerInfoResponse> getCustomerInfo(@RequestHeader("token") String token);
}
