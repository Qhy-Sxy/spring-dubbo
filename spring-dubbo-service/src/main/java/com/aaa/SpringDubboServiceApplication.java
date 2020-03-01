package com.aaa;

import com.alibaba.dubbo.container.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class SpringDubboServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDubboServiceApplication.class, args);
        Main.main(args);
    }

}
