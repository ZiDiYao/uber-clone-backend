package org.zidi.rules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.zidi.ServiceCustomerApplication;

public class ServiceRulesApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ServiceRulesApplication.class);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);
    }
}
