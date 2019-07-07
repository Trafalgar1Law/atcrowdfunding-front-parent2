package com.atguigu.front.enums;

public enum AcctTypeEnum {
    COMPANT("0","企业"),
    PERSONAL_COMPANT("1","个体"),
    PERSON("2","个人"),
    GOV("3","政府");

    private String code;
    private String msg;

    private AcctTypeEnum(String code,String msg){
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
