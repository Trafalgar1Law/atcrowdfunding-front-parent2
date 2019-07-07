package com.atguigu.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.front.bean.TMember;
import com.atguigu.front.bean.TMemberExample;
import com.atguigu.front.constant.AppConstant;
import com.atguigu.front.enums.AuthStatusEnum;
import com.atguigu.front.enums.UserTypeEnum;
import com.atguigu.front.exception.UserEmailException;
import com.atguigu.front.exception.UserLoginacctException;
import com.atguigu.service.MemberService;
import com.atguigu.user.dao.TMemberMapper;
import com.atguigu.vo.req.MemberRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

//实现类放在容器中
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    TMemberMapper memberMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void regist(MemberRegisterVo memberRegisterVo) {
        //首先要校验验证码

        //1
        String mobile = memberRegisterVo.getMobile();
        boolean m = checkMobile(mobile);
        if(!m){
            throw new UserLoginacctException();
        }
        //2
        String email = memberRegisterVo.getEmail();
        boolean e = checkEmail(email);
        if(!e){
            throw new UserEmailException();
        }
        //3
        TMember member=new TMember();
        member.setLoginacct(mobile);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode(memberRegisterVo.getPassword());
        //根据数据库把必填的选项进行设置
        member.setUserpswd(encode);
        member.setUsername(mobile);
        member.setEmail(memberRegisterVo.getEmail());
        member.setAuthstatus(AuthStatusEnum.UNAUTH.getCode());
        member.setUsertype(UserTypeEnum.PERSONAL.getCode());
        member.setRealname("未命名");
        //这两个也没什么默认值，实名认证在家吧
        //身份证号
            /*member.setCardnum("");
            //账户类型
            member.setAccttype("");*/

        memberMapper.insertSelective(member);

    }

    @Override
    public TMember login(String mobile, String password) {
        TMemberExample example=new TMemberExample();
        example.createCriteria().andLoginacctEqualTo(mobile);
        List<TMember> members = memberMapper.selectByExample(example);

        //看密码是否匹配
        if(members!=null&&members.size()==1){
            TMember member = members.get(0);
            String userpswd = member.getUserpswd();

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            boolean matches = encoder.matches(password, userpswd);
            if(matches){
                return member;
            }else
                return null;
        }else
        {
            return null;
        }

    }

    @Override
    public TMember getMemberInfo(String accessToken) {
        String s = stringRedisTemplate.opsForValue().get(AppConstant.MEMBER_LOGIN_CACHE_PREFIX + accessToken);
        //字符串转为对象
        //咋转呢？
        TMember member = JSON.parseObject(s, TMember.class);
        //如果用户数据有更新，去数据库实时查
        TMember member1 = memberMapper.selectByPrimaryKey(member.getId());
        return member1;
    }

    private boolean checkMobile(String mobile) {
        TMemberExample example=new TMemberExample();
        example.createCriteria().andLoginacctEqualTo(mobile);
        long count = memberMapper.countByExample(example);

        return count==0?true:false;
    }


    private boolean checkEmail(String email) {
        TMemberExample example=new TMemberExample();
        example.createCriteria().andEmailEqualTo(email);
        long count = memberMapper.countByExample(example);

        return count==0?true:false;
    }
}
