package org.zidi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.zidi.mapper")
public class ServiceCustomerApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceCustomerApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET); // 强制指定为 Web 类型
        app.run(args);
    }
}
