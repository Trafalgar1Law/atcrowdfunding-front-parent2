package com.atguigu.project.controller;

import com.atguigu.front.bean.TTag;
import com.atguigu.front.bean.TType;
import com.atguigu.front.common.AppResponse;
import com.atguigu.project.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Api(tags = "项目信息模块")
@RequestMapping("/project")
@RestController
public class ProjectInfoController {
    @Autowired
    ProjectService projectService;

    @ApiOperation("获取项目系统分类信息")
    @GetMapping("/sys/type")
    public AppResponse<List<TType>>  sysType(){
        List<TType> types=projectService.getSysTypes();
        return AppResponse.success(types);
    }

    @ApiOperation("获取项目系统标签信息")
    @GetMapping("/sys/tags")
    public AppResponse<List<TTag>> sysTags(){
        List<TTag> tags=projectService.getSysTags();
        return AppResponse.success(tags);
    }
}
