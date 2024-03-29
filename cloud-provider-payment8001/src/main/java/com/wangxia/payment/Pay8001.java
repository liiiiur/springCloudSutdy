package com.wangxia.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.wangxia.core.core.common.api")
@EnableDiscoveryClient
public class Pay8001 {
    public static void main(String[] args) {
        SpringApplication.run(Pay8001.class, args);
    }
}
