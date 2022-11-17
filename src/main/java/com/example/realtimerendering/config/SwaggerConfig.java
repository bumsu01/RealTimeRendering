package com.example.realtimerendering.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createrestapi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();

        docket.alternateTypeRules(AlternateTypeRules.newMapRule(String.class, List.class));
        docket.alternateTypeRules(AlternateTypeRules.newMapRule(List.class, Model.class));
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("kakao Project swagger api 문서")
                .description("API 테스트 Tool")
                .version("v1.0")
                .contact(new Contact("kim bumsu", "", "bumsu01@gmail.com"))
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .build();
    }
}
