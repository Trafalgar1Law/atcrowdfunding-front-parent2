package com.atguigu.component;


import com.alibaba.druid.util.StringUtils;
import com.atguigu.front.constant.AppConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginKeyExpireFilter implements Filter {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.debug("LoginKeyExpireFilter进行拦截,对登录信息进行自动续期");

        HttpServletRequest request=(HttpServletRequest) servletRequest;

        String accessToken = request.getParameter("accessToken");
        //注册时就没有令牌
        if(StringUtils.isEmpty(accessToken)){
            //不是登陆后进行的请求，不用操作
            //放行请求
            chain.doFilter(request,response);
        }else{
            //否则就要续期了
            stringRedisTemplate.expire(AppConstant.MEMBER_LOGIN_CACHE_PREFIX+accessToken,30, TimeUnit.MINUTES);

        }
    }

    @Override
    public void destroy() {

    }
}
