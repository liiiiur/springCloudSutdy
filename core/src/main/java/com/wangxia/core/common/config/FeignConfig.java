package com.wangxia.core.common.config;

import com.wangxia.core.common.component.FeignTokenInterceptor;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new FeignTokenInterceptor();
    }
}
