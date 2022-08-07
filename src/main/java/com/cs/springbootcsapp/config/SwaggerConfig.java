package com.cs.springbootcsapp.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("com.cs.springbootcsapp.web"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
            .globalResponses(HttpMethod.GET, Arrays.asList(
                new ResponseBuilder().code("500")
                    .description("500 message").build(),
                new ResponseBuilder().code("403")
                    .description("Forbidden!!!!!").build()
            ));
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo("CS  Fleet Rest API ", "Some custom description of API.", "CS Car Service API", "Terms of service", new Contact("Admin", "www.fleet.com", "admin@fleet.com"), "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }
}