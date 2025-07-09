package org.zidi.uber;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.zidi.uber.redis.service.RedisDemoService;

import jakarta.annotation.Resource;

@SpringBootApplication
public class ExtraPracticeApplication implements CommandLineRunner {

    @Resource
    private RedisDemoService redisDemoService;

    public static void main(String[] args) {
        SpringApplication.run(ExtraPracticeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        redisDemoService.testRedis();
    }
}
