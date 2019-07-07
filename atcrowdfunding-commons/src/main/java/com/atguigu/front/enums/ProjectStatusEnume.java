package com.atguigu.front.enums;

public enum ProjectStatusEnume {
    DRAFT("0","草稿"),
    SUBMIT_AUTH("1","提交审核申请"),
    AUTHINFG("2","后台正在审核"),
    AUTHED("3","后台审核通过"),
    AUTHFAIL("4","审核失败");

    private String code;
    private String msg;

    private ProjectStatusEnume(String code,String msg){
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
