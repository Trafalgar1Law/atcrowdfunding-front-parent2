package com.atguigu.service.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "artcrowdfunding-user")
public class UserServiceFeign {

}
