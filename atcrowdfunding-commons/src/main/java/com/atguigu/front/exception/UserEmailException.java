package com.atguigu.front.exception;

import net.bytebuddy.dynamic.loading.ClassInjector;

public class UserEmailException extends RuntimeException {
    public UserEmailException(){
        super("用户邮箱已经存在");
    }
}
