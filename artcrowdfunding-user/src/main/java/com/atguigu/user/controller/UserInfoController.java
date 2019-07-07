package com.atguigu.user.controller;

import com.atguigu.front.bean.TMember;
import com.atguigu.front.common.AppResponse;
import com.atguigu.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "用户个人信息模板")
@RequestMapping("/user/info")
@RestController
public class UserInfoController {
    @Autowired
    MemberService memberService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @ApiOperation("获取个人信息")
    @GetMapping("/")
    public AppResponse<TMember> getUserInfo(@RequestParam("accessToken") String accessToken){
        TMember member=memberService.getMemberInfo(accessToken);
        //超时了怎么办呢？进行续期，每一个操作过来，重新设置超时
       // stringRedisTemplate.expire(AppConstant.MEMBER_LOGIN_CACHE_PREFIX+accessToken,30, TimeUnit.MINUTES);
        //每个方法都要续，写一个过滤器
        member.setId(null);
        member.setUserpswd(null);
        return AppResponse.success(member);
    }
}
