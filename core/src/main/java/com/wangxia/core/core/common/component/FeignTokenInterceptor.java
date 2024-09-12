package com.wangxia.core.core.common.component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FeignTokenInterceptor implements RequestInterceptor{

    @Override
    public void apply(RequestTemplate requestTemplate) {
        String token = getToken();
        if (token != null) {
            requestTemplate.header("Token",token);
        }
    }

    private String getToken() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("Authentication: {}", authentication);
        if (authentication != null && authentication.getCredentials() != null) {
            // 假设Token是存储在Credentials中的，例如JWT Token
            return authentication.getCredentials().toString();
        }
        return null;
    }
}
