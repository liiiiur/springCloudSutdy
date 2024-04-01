package com.wangxia.payment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.wangxia.core")
public class Pay8001 {
    public static void main(String[] args) {
        SpringApplication.run(Pay8001.class, args);
    }
}
