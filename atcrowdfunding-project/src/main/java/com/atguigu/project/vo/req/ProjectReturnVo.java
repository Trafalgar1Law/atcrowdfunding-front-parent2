package com.atguigu.project.vo.req;

import lombok.Data;

@Data
public class ProjectReturnVo extends BaseVo{
    //回报id和项目id我们不知道，其他的复制过来
    private String type;

    private Integer supportmoney;


    private String content;


    private Integer count;


    private Integer signalpurchase;

    private Integer purchase;

    private Integer freight;

    private String invoice;


    private Integer rtndate;



}
