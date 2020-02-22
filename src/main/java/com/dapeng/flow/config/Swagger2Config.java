package com.dapeng.flow.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.flowable.rest.service.api.RestResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 描述:swagger配置类
 *
 * @author liuxz
 * @date 2019/8/16 11:46
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "com.dapeng.flow.controller")
@ComponentScan(basePackages = "org.flowable.rest.service.api")
public class Swagger2Config {

    @Autowired
    protected ObjectMapper objectMapper;

    @Bean()
    public RestResponseFactory restResponseFactory() {
        RestResponseFactory restResponseFactory = new RestResponseFactory(objectMapper);
        return restResponseFactory;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("工作流微服务API文档")
//                .description("工作流微服务项目")
                //服务条款网址
//                .termsOfServiceUrl("https://")
//                .version("1.0")
//                .contact(new Contact("liu", "http://", "mail@qq.com"))
                .build();
    }

}

