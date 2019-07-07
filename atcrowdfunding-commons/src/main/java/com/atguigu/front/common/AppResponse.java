package com.atguigu.front.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class AppResponse<T> {
    @ApiModelProperty("请求状态码 0：成功")
    private Integer code;

    @ApiModelProperty("请求信息")
    private String msg;

    @ApiModelProperty("真正要返回的数据")
    private T data;


    //快速返回成功
    public static<T> AppResponse<T> success(T data){
        AppResponse<T> response = new AppResponse<>();
        response.setCode(0);
        response.setMsg("操作成功");
        response.setData(data);
        return response;
    }

    //快速返回失败信息
    public static<T> AppResponse<T> fail(T data){
        AppResponse<T> response = new AppResponse<>();
        response.setCode(1);
        response.setMsg("操作失败");
        response.setData(data);
        return response;
    }

    public AppResponse msg(String msg){
        this.setMsg(msg);
        return  this;
    }


}
