package com.example.databasebigwork.config;

import com.example.databasebigwork.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class myInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/res/**",
//                        "/user/login",
//                        "/",
//                        "/user/register");

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
