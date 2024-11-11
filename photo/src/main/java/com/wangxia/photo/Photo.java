package com.wangxia.photo;

import com.wangxia.core.common.Packages;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {Packages.core,Packages.photo})
@MapperScan("com.wangxia")
public class Photo {
    public static void main(String[] args) {
        SpringApplication.run(Photo.class,args);
    }
}
