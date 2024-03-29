package com.wangxia.payment.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Swagger3Config {

    @Bean
    public GroupedOpenApi getOpenApi() {
        return GroupedOpenApi.builder()
                .group("payment-api")
                .packagesToScan("com.wangxia.payment")
                .build();
    }


}
