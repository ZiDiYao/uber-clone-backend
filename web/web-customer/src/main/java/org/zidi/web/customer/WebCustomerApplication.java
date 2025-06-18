package org.zidi.web.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "org.zidi.customer.client.feign")
public class WebCustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebCustomerApplication.class, args);
    }
}
