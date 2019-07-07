package com.atguigu.project.service;

import com.atguigu.front.bean.TTag;
import com.atguigu.front.bean.TType;
import com.atguigu.project.vo.req.BaseVo;
import com.atguigu.project.vo.req.ProjectBaseInfoVo;
import com.atguigu.project.vo.req.ProjectReturnVo;

import java.util.List;

public interface ProjectService {

    String initProject(String accessToken);

    List<TTag> getSysTags();

    List<TType> getSysTypes();

    boolean saveTempBaseInfo(ProjectBaseInfoVo projectBaseInfoVo);

    boolean saveTempReturn(List<ProjectReturnVo> returns);

    void submitProjectToDb(BaseVo vo);

    void tempProjectToDb(BaseVo vo);
}
