package com.test.cloud.order;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class TestOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestOrderApplication.class, args);
    }
}
