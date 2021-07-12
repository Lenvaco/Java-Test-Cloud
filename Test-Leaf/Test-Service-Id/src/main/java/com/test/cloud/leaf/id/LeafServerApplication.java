package com.test.cloud.leaf.id;

import com.baomidou.mybatisplus.autoconfigure.IdentifierGeneratorAutoConfiguration;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class, IdentifierGeneratorAutoConfiguration.class})
@EnableDubbo
public class LeafServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeafServerApplication.class, args);
	}
}
