package com.test.cloud.product;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.test.cloud")
@EnableDubbo
public class TestProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestProductApplication.class, args);
    }
}
