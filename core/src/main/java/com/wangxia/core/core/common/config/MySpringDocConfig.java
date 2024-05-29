package com.wangxia.core.core.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySpringDocConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                .addSecuritySchemes("basic", new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .bearerFormat("JWT")
                        .scheme("bearer")))
                .info(new Info()
                        .title("核心API")
                        .version("1.0")
                        .description("核心的API")
                );
    }
}
