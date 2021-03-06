package com.atguigu.project.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel
@Data
public class BaseVo {
    //去下一页的时候仍然要带项目的令牌，用户的令牌
    @ApiModelProperty(value = "项目临时令牌",required = true)
    private String projectToken;//项目的临时token
    @ApiModelProperty(value = "访问令牌",required = true)
    private String accessToken;


}
