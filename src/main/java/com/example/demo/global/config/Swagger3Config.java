package com.example.demo.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(title = "Demo",
                description = "Demo Api 명세서",
                version = "v1"))
@RequiredArgsConstructor
@Configuration
public class Swagger3Config {

    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/v1/**"};

        SecurityScheme cookieAuthScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.COOKIE)
                .name("session_id");

        return GroupedOpenApi.builder()
                .group("Demo API v1")
                .pathsToMatch(paths)
                .build();
    }

}
