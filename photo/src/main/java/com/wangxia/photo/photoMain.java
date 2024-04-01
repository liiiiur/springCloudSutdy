package com.wangxia.photo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableWangxiaFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.wangxia")
public class photoMain {
    public static void main(String[] args) {
        SpringApplication.run(photoMain.class,args);
    }
}
