package com.wangxia.order;

import com.wangxia.core.common.Packages;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {Packages.core,Packages.order})
@MapperScans({
        @MapperScan("com.wangxia.order.mapper"),
        @MapperScan("com.wangxia.core.common.mapper")
})
public class Order {
    public static void main(String[] args) {
        SpringApplication.run(Order.class,args);
    }
}
