package com.example.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  public static final String SWAGGER_TITLE = "spring-boot";
  public static final String SWAGGER_DESC = "spring-boot描述";

  @Bean
  public Docket documentation() {
    return new Docket(DocumentationType.SWAGGER_2) //
        .select() //
        .apis(RequestHandlerSelectors.any()) //
        .paths(regex("/.*"))
        .build().apiInfo(metadata());
  }

  private ApiInfo metadata() {
    return new ApiInfoBuilder().title(SWAGGER_TITLE) //
        .description(SWAGGER_DESC) //
        .version("1.0").build();
  }
}
