package com.atguigu.user.controller;



import com.alibaba.fastjson.JSON;
import com.atguigu.component.SmsTemplate;
import com.atguigu.front.bean.TMember;
import com.atguigu.front.common.AppResponse;
import com.atguigu.front.constant.AppConstant;
import com.atguigu.front.exception.UserEmailException;
import com.atguigu.front.exception.UserLoginacctException;
import com.atguigu.service.MemberService;
import com.atguigu.vo.req.MemberRegisterVo;
import com.atguigu.vo.resp.MemberResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(tags = "用户登录、注册服务")
@RestController
@RequestMapping("/user")
@Slf4j
public class UserLoginRegistController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    MemberService memberService;
    @Autowired
    SmsTemplate smsTemplate;


    @ApiOperation("用户登录")
    @PostMapping("/login")
    //因为有多个参数，所以以后参数的swagger写在上面
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile",value = "账号（手机号）",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    public AppResponse<MemberResponseVo> login(@RequestParam(value = "mobile",required = true) String mobile,
                                               @RequestParam(value = "password",required=true) String password){
        //登陆成功就返回对象
        TMember member=memberService.login(mobile,password);
        if(member==null){
            return AppResponse.fail("").msg("登录失败");
        }else{
            //但是不是所有信息都返回，所以在抽取一个vo
            MemberResponseVo memberResponseVo=new MemberResponseVo();
            //一个个的把member的属性放到memberresponse太麻烦了，spring有个工具类，
            //只要是member里的同名属性都会进入到memberresponse的属性里面

            BeanUtils.copyProperties(member,memberResponseVo);
            String token = UUID.randomUUID().toString().replace("-", "");
            memberResponseVo.setAccessToken(token);
            String string = JSON.toJSONString(memberResponseVo);
            //保存用户的token和用户详情到redis
            stringRedisTemplate.opsForValue().set(AppConstant.MEMBER_LOGIN_CACHE_PREFIX+token,string,30,TimeUnit.MINUTES);
            return AppResponse.success(memberResponseVo).msg("登陆成功");
        }
    }



    /**
     * Controller负责收集，顶多做一个 值合法性（非空）
     *
     * 业务逻辑合法性；（service来做）
     * @param memberRegisterVo
     * @return
     */
    @ApiOperation("用户注册")
    @PostMapping("/register")
    public AppResponse<String> register(MemberRegisterVo memberRegisterVo){

        log.debug("{} 用户正在注册：",memberRegisterVo.getMobile());
        //校验；
        if(StringUtils.isEmpty(memberRegisterVo.getCode())){
            return AppResponse.fail("").msg("验证必须填写");
        }
        if(StringUtils.isEmpty(memberRegisterVo.getEmail())){
            return AppResponse.fail("").msg("邮箱必须填写");
        }
        if(StringUtils.isEmpty(memberRegisterVo.getMobile())){
            return AppResponse.fail("").msg("手机号必须填写");
        }
        if(StringUtils.isEmpty(memberRegisterVo.getPassword())){
            return AppResponse.fail("").msg("密码必须填写");
        }

        //校验验证码
        String code = stringRedisTemplate.opsForValue().get(AppConstant.CODE_CACHE_PREFIX + memberRegisterVo.getMobile());
        if(StringUtils.isEmpty(code)){
            return AppResponse.fail("").msg("验证码过期，请重新获取");
        }else {
            if(!code.equalsIgnoreCase(memberRegisterVo.getCode())){
                return AppResponse.fail("").msg("验证码错误");
            }else {
                //异常机制；验证码验证通过；销毁验证码；
                stringRedisTemplate.delete(AppConstant.CODE_CACHE_PREFIX + memberRegisterVo.getMobile());
                try {
                    memberService.regist(memberRegisterVo);
                } catch (UserEmailException e) {
                    return AppResponse.fail("").msg(e.getMessage());
                } catch (UserLoginacctException e) {
                    return AppResponse.fail("").msg(e.getMessage());
                }
            }
        }


        return AppResponse.success("");
    }




    @ApiOperation("获取短信验证码")
    @PostMapping ("/sendsms")
    public AppResponse<String> sendSms(@RequestParam("mobile") String mobile){
        String code = UUID.randomUUID().toString().replace("-","").substring(0,5);
        smsTemplate.sendSms(mobile,code);


        //1、将验证码放在redis中，下一次进行验证； k（mobile）-v（code）；redis中的key一般都要设置过期时间
        //所有在redis中应该有前缀，每一个业务的前缀不一样；
        stringRedisTemplate.opsForValue().set(AppConstant.CODE_CACHE_PREFIX+mobile,code,5, TimeUnit.MINUTES);

        return AppResponse.success("").msg("短信发送完成");
    }
}
