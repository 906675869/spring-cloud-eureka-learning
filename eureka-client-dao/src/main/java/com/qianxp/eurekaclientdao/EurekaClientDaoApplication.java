package com.qianxp.eurekaclientdao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaClientDaoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientDaoApplication.class, args);
    }
}
