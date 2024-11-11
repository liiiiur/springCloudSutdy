package com.wangxia.core.common.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${test}")
    private String name;

    @PostMapping("/test1")
    public String test1(){
        return name;
    }

    @PostMapping("/test2")
    public String test2(){
        return "test1";
    }

    @PostMapping("/test3")
    public String test3(){
        return "test1";
    }
}
