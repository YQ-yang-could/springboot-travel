package com.yang.travel.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("all-admin-login");
        registry.addViewController("/main.html").setViewName("all-admin-index");
        registry.addViewController("/404.html").setViewName("all-admin-404");
    }
}
