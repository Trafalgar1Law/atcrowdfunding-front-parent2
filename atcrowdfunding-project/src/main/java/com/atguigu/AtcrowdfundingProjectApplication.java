package com.atguigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableCircuitBreaker//开启熔断
@EnableFeignClients  //开启feign的声明式远程调用
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.atguigu.project.dao")
public class AtcrowdfundingProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtcrowdfundingProjectApplication.class, args);
    }

}
