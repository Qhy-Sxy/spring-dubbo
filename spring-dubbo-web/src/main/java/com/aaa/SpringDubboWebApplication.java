package com.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringDubboWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDubboWebApplication.class, args);
    }

}
