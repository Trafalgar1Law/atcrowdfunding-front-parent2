package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//因为要远程调用，也要开启feign声明式远程调用
//开启断路器
@ServletComponentScan(basePackages = "com.atguigu.component") //组东扫描servlet的组件
@MapperScan("com.atguigu.user.dao")
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@EnableSwagger2
@SpringBootApplication
public class ArtcrowdfundingUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArtcrowdfundingUserApplication.class, args);
    }

}
