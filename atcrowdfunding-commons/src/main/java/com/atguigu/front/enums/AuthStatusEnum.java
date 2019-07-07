package com.atguigu.front.enums;

import lombok.Data;

/**
 * 实名认证状态枚举
 */
//@Data只能用在类上，没办法自己写吧
public enum AuthStatusEnum {
    UNAUTH("0","未实名人认证"),
    AUTHING("1","实名认证中"),
    AUTHED("2","已实名认证");

    //状态
    private String code;

    //提示
    private String msg;

    private  AuthStatusEnum( String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
