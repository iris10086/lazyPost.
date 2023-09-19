package com.example.databasebigwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //  启用Swagger
public class SwaggerConfig {
    /**
     * 配置swagger的核心对象
     * @return Docket
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.databasebigwork.controller")) // 设置包扫描规则
                .paths(PathSelectors.any())
                .build()
                .groupName("all");
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.databasebigwork.controller")) // 设置包扫描规则
                .paths(PathSelectors.any())
                .build()
                .groupName("address");
    }

    /**
     * 获取Swagger页面信息
     * @return ApiInfo
     */
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("iris", "http://www.baidu.com", "1351705036@qq.com");
        return new ApiInfo("iris's Api Documentation",
                "A little project's Api Documentation",
                "v1.0",
                "http://www.bing.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }
}
