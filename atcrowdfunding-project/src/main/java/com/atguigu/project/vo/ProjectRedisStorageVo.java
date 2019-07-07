package com.atguigu.project.vo;

import com.atguigu.front.bean.TReturn;
import lombok.Data;

import java.util.List;

/**
 * 项目全量信息,手机页面信息
 */
@Data
public class ProjectRedisStorageVo {
    private String accessToken;
    //因为填写信息时还不确认是哪个项目，先用一个临时的保存一下

    private String projectToken;//项目的临时token
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
    //=========================以上是第一屏的信息==============================

    private List<TReturn> projectReturns;//项目回报


}
