package com.atguigu.front.enums;

public enum ImgTypeEnume {
    HEADER_IMG((byte)0,"头图"),
    DEATAIL_IMG((byte)1,"详情图");

    private byte code;
    private String msg;


    private ImgTypeEnume(byte code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public void setCode(byte code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
