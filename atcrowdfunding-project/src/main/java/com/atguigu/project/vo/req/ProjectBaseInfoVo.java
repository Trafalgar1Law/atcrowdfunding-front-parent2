package com.atguigu.project.vo.req;

import lombok.Data;

import java.util.List;
@Data
public class ProjectBaseInfoVo extends BaseVo{
    //是第一屏的vo

    private Integer memberid;//会员id（谁发的项目）

    private List<Integer> typeids; //项目的分类id
    //因为有好多标签
    private List<Integer> tagids; //项目的标签id
    private String name;//项目名称
    private String remark;//项目简介
    private Integer money;//筹资金额
    private Integer day;//筹资天数
    private String headerImage;//项目头部图片
    private List<String> detailsImage;//项目详情图片

}
