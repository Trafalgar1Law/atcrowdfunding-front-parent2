package com.atguigu.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class MemberResponseVo {
    //因为是member中的部分数据，直接复制即可
    @ApiModelProperty("访问令牌")
    private  String accessToken;//传说中的访问令牌
    private Integer id;
    private String loginacct;

    private String userpswd;


    private String username;


    private String email;

    private String authstatus;

    private String usertype;

    private String realname;

    private String cardnum;

    private String accttype;

}
