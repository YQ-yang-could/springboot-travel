package com.yang.travel.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
//    @Bean
//    public Docket docket(Environment envi){
//        //设置环境测试或者发布:当时发布环境时自动关闭swagger
//        Profiles profiles=Profiles.of("dev","test");
//        boolean flag=envi.acceptsProfiles(profiles);
//        System.out.println(flag);
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .enable(flag)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.yang.travel.controller"))
//                .build();
//
//    }
    @Bean
    public Docket docket(){
               return new Docket(DocumentationType.SWAGGER_2)
                       .apiInfo(apiInfo());
//                       .select()
//                       .apis(RequestHandlerSelectors.basePackage("com.yang.travel.controller"))
//                       .build();
    }
    public ApiInfo apiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT=new Contact("杨炎泉","https://blog.csdn.net/weixin_45003863","yyq-11@139.com");
        return new ApiInfo("Yang_travel的API文档",
                "版权所有~",
                "v1.0",
                "https://localhost:8080",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
