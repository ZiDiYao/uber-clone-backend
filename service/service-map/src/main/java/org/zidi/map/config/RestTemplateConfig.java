package org.zidi.map.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
    @Bean(name = "myRestTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
