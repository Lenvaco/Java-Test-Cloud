package com.test.cloud.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.test.cloud")
@EnableDubbo
public class TestUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestUserApplication.class, args);
    }
}
