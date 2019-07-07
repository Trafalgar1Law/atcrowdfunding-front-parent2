package com.atguigu.front.enums;

/**
 * 用户类型枚举
 */
public enum UserTypeEnum {
    PERSONAL("0","个人"),
    COMPANY("1","企业");

    private String code;
    private String msg;


    private UserTypeEnum(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
