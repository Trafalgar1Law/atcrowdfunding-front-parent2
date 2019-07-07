package com.atguigu.front.exception;

public class UserLoginacctException extends RuntimeException{
    public UserLoginacctException(){
        super("用户手机号已经存在");
    }
}
