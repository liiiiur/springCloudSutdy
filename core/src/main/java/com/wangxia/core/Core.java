package com.wangxia.core;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.wangxia.core")
@SpringBootApplication
@EnableDiscoveryClient
@MapperScans({
        @MapperScan("com.wangxia.core.common.mapper"),
        @MapperScan("com.wangxia.core.file.mapper")
})
public class Core{

    public static void main(String[] args) {
        SpringApplication.run(Core.class, args);
    }

}
