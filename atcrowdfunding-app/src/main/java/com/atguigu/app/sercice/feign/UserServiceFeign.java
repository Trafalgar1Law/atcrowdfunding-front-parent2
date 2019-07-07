package com.atguigu.app.sercice.feign;

import com.atguigu.front.common.AppResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@FeignClient(value = "artcrowdfunding-user")
public interface UserServiceFeign {
    @PostMapping("/user/login")
    public AppResponse<MemberResponseVo> login(@RequestParam(value = "mobile", required = true) String mobile,
                                               @RequestParam(value = "password", required = true) String password);


}