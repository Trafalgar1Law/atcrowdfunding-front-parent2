package com.atguigu.project.controller;

import com.alibaba.druid.util.StringUtils;
import com.atguigu.front.bean.TReturn;
import com.atguigu.front.common.AppResponse;
import com.atguigu.front.constant.AppConstant;
import com.atguigu.project.component.OssTemplate;
import com.atguigu.project.service.ProjectService;
import com.atguigu.project.vo.Datas;
import com.atguigu.project.vo.req.BaseVo;
import com.atguigu.project.vo.req.ProjectBaseInfoVo;
import com.atguigu.project.vo.req.ProjectReturnVo;
import com.atguigu.project.vo.resp.ProjectTempVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Slf4j
@Api(tags = "项目发起模块")
@RestController
@RequestMapping("/project/create")
public class ProjectCreateController {
    @Autowired
    ProjectService projectService;
    //调用阿里云的那个上传
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    OssTemplate ossTemplate;
    @ApiOperation("项目初始创建第一步")
    @PostMapping("/init")
    public AppResponse<ProjectTempVo> init(@RequestParam("accessToken") String accessToken){
        //点击阅读并同意协议，新创一个临时项目
        //这个访问令牌以后都是必须的，登陆后的所有请求都要带上

        //返回刚创建的项目的临时令牌
        String projectToken=projectService.initProject(accessToken);

        if(StringUtils.isEmpty(projectToken)){
            //没登陆
            return AppResponse.fail("").msg("项目创建异常，请确认登录状态");
        }

        ProjectTempVo projectTempVo = new ProjectTempVo();
        projectTempVo.setProjectToken(projectToken);
        return AppResponse.success(projectTempVo);
    }


    @ApiOperation("项目初始创建第二步-项目基本信息保存")
    @PostMapping("/saveBaseInfo")
    public AppResponse<ProjectTempVo> saveBaseInfo(ProjectBaseInfoVo projectBaseInfoVo
            , @RequestParam("accessToken") String accessToken){
            boolean b=projectService.saveTempBaseInfo(projectBaseInfoVo);
            return AppResponse.success("成功").msg("基本数据保存成功");
    }


    @ApiOperation("项目初始创建第三步-添加项目回报挡位")
    @PostMapping("/return")
    public AppResponse<ProjectTempVo> addReturn(@RequestBody List<ProjectReturnVo> returns){
        log.debug("回报对象{}",returns);
        boolean b=projectService.saveTempReturn(returns);
        return AppResponse.success("成功").msg("项目回报数据保存成功");
    }

    @ApiOperation("项目图片上传")
    @PostMapping("/update")
    public AppResponse<List<String>> update(@RequestParam("file") MultipartFile[] file,
                                           @RequestParam("accessToken") String accessToken) throws IOException {
        //要检验一下用户登陆没，redis里面有就行
        Boolean hasKey = stringRedisTemplate.hasKey(AppConstant.MEMBER_LOGIN_CACHE_PREFIX + accessToken);
        if(!hasKey){
            //没有就是没登录
            return  AppResponse.fail("").msg("请先登录");
        }


        //用来分装所有文件的路径
        List<String> urls=new ArrayList<>();
        if(file!=null){
            for (MultipartFile multipartFile : file) {
                //现在已经有多个文件了
                if(!multipartFile.isEmpty()){
                    //非空就可以上传到云上了
                    byte[] bytes = multipartFile.getBytes();
                    String filename = multipartFile.getOriginalFilename();

                    try {
                        String upload = ossTemplate.upload(bytes, filename);
                        urls.add(upload);
                    } catch (FileNotFoundException e) {

                    }
                }
            }
        }
        return AppResponse.success(urls);
    }

    @ApiOperation("项目提交审核申请")
    @PostMapping("/submit")
    public AppResponse<String> submit(BaseVo vo){
        projectService.submitProjectToDb(vo);
        return AppResponse.success("");
    }

    @ApiOperation("项目草稿保存")
    @PostMapping("/tempsave")
    public AppResponse<String> tempSave(BaseVo vo){
        projectService.tempProjectToDb(vo);
        return AppResponse.success("");
    }

}
