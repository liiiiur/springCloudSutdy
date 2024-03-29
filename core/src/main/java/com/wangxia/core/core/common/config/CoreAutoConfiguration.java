package com.wangxia.core.core.common.config;

import com.wangxia.core.core.common.api.RemoteOrderService;
import com.wangxia.core.core.common.api.RemotePhotoService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConditionalOnClass({RemotePhotoService.class,RemoteOrderService.class})
public class CoreAutoConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        System.out.println("测试");
        return new RestTemplate();
    }
}
