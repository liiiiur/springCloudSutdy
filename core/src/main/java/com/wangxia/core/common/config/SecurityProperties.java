package com.wangxia.core.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@RefreshScope
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private String loginPage;

    private List<String> permitAll;

}
