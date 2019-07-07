package com.atguigu.service;

import com.atguigu.front.bean.TMember;
import com.atguigu.front.exception.UserEmailException;
import com.atguigu.front.exception.UserLoginacctException;
import com.atguigu.vo.req.MemberRegisterVo;

public interface MemberService {
    //这样别人调用的时候要么抛出异常，要么try,catch
    void regist(MemberRegisterVo memberRegisterVo) throws UserLoginacctException, UserEmailException;

    TMember login(String mobile, String password);

    TMember getMemberInfo(String accessToken);
}
