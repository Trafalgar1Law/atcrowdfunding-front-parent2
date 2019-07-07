package com.atguigu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class AppMvcConfig implements WebMvcConfigurer {
   @Override
    public  void addViewControllers(ViewControllerRegistry registry) {
        //视图解析拼串来到指定地址  templates/login.html
        registry.addViewController("/login.html").setViewName("login");
    }




}
