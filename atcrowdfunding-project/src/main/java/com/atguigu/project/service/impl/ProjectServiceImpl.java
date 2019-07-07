package com.atguigu.project.service.impl;

import com.alibaba.fastjson.JSON;
import com.atguigu.front.bean.*;
import com.atguigu.front.constant.AppConstant;
import com.atguigu.front.enums.ImgTypeEnume;
import com.atguigu.front.enums.ProjectStatusEnume;
import com.atguigu.project.dao.*;
import com.atguigu.project.service.ProjectService;
import com.atguigu.project.vo.ProjectRedisStorageVo;
import com.atguigu.project.vo.req.BaseVo;
import com.atguigu.project.vo.req.ProjectBaseInfoVo;
import com.atguigu.project.vo.req.ProjectReturnVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    TTagMapper tagMapper;
    @Autowired
    TTypeMapper typeMapper;
    @Autowired
    TProjectMapper tPojectMapper;
    @Autowired
    TProjectImagesMapper imagesMapper;
    @Autowired
    TProjectTagMapper projectTagMapper;
    @Autowired
    TProjectTypeMapper projectTypeMapper;
    @Autowired
    TReturnMapper returnMapper;
    @Override
    public String initProject(String accessToken) {
        String projectToken = UUID.randomUUID().toString().replace("-", "");
        ProjectRedisStorageVo projectRedisStorageVo=new ProjectRedisStorageVo();
        //确认用户登录状态
        String s = stringRedisTemplate.opsForValue().get(AppConstant.MEMBER_LOGIN_CACHE_PREFIX+accessToken);

        TMember member = JSON.parseObject(s, TMember.class);

        if(member==null){
            return null;
        }

        //设置项目信息


        projectRedisStorageVo.setAccessToken(accessToken);

        projectRedisStorageVo.setProjectToken(projectToken);

        projectRedisStorageVo.setMemberid(member.getId());
        //然后将临时项目的基本信息，保存到redis中
        String toJSONString = JSON.toJSONString(projectRedisStorageVo);
        stringRedisTemplate.opsForValue().set(AppConstant.PROJECT_TEMP_CACHE_PREFIX+projectToken,toJSONString);
        return projectToken;
    }

    @Override
    public List<TTag> getSysTags() {
        //查那个就用哪个mapper

        return tagMapper.selectByExample(null);
    }

    @Override
    public List<TType> getSysTypes() {
        return typeMapper.selectByExample(null);
    }

    @Override
    public boolean saveTempBaseInfo(ProjectBaseInfoVo projectBaseInfoVo) {
        //页面提交了第一屏的基本数据
        ProjectRedisStorageVo projectRedisStorageVo=new ProjectRedisStorageVo();
        //自己set太麻烦了，直接收集页面数据放进去比较好
            //BeanUtils.copyProperties(projectBaseInfoVo,projectRedisStorageVo);
            //但是不能直接放到redis中，因为原本的是有元数据的，相当于要把数据合并起来
        String projectToken = projectBaseInfoVo.getProjectToken();
        //去redis中拿到 之前保存的项目的临时信息
        String s = stringRedisTemplate.opsForValue().get(AppConstant.PROJECT_TEMP_CACHE_PREFIX + projectToken);
        ProjectRedisStorageVo parseObject = JSON.parseObject(s, ProjectRedisStorageVo.class);

        //复制新的vo到原来vo
        BeanUtils.copyProperties(projectBaseInfoVo,parseObject);


        //把这个对象还要存回redis
        String jsonString = JSON.toJSONString(parseObject);
        stringRedisTemplate.opsForValue().set(AppConstant.PROJECT_TEMP_CACHE_PREFIX+projectToken,jsonString);

        return true;
    }

    @Override
    public boolean saveTempReturn(List<ProjectReturnVo> returns) {
        //临时保存到redis中
        String s = stringRedisTemplate.opsForValue().get(AppConstant.PROJECT_TEMP_CACHE_PREFIX + returns.get(0).getProjectToken());
        ProjectRedisStorageVo parseObject = JSON.parseObject(s, ProjectRedisStorageVo.class);

        List<TReturn> returnList=new ArrayList<>();
        for (ProjectReturnVo returnVo : returns) {
            TReturn tReturn = new TReturn();
            BeanUtils.copyProperties(returnVo,tReturn);
            returnList.add(tReturn);
        }
        parseObject.setProjectReturns(returnList);

        //重新保存到redis
        String string = JSON.toJSONString(parseObject);

        stringRedisTemplate.opsForValue().set(AppConstant.PROJECT_TEMP_CACHE_PREFIX+returns.get(0).getProjectToken(),string);

        return true;
    }

    @Override
    public void submitProjectToDb(BaseVo vo) {
        saveProject(vo,ProjectStatusEnume.SUBMIT_AUTH);

    }
    @Transactional
    public void saveProject(BaseVo vo,ProjectStatusEnume statusEnume) {
        //保存之前我们要知道要保存的是哪个项目
        String s = stringRedisTemplate.opsForValue().get(AppConstant.PROJECT_TEMP_CACHE_PREFIX + vo.getProjectToken());
        ProjectRedisStorageVo redisStorageVo = JSON.parseObject(s, ProjectRedisStorageVo.class);

        //保存到数据库
        //把数据拆成project
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        TProject tProject = new TProject();
        BeanUtils.copyProperties(redisStorageVo,tProject);
        tProject.setStatus(ProjectStatusEnume.SUBMIT_AUTH.getCode());

        tProject.setCreatedate(dateFormat.format(new Date()));

        int i = tPojectMapper.insertSelective(tProject);
        //保存到项目以后要获取项目的id
        Integer projectId = tProject.getId();

        //保存项目图片的信息
        TProjectImages images = new TProjectImages();
        //保存头图
        String headerImage = redisStorageVo.getHeaderImage();
        images.setImgurl(headerImage);
        images.setImgtype(ImgTypeEnume.HEADER_IMG.getCode());
        images.setProjectid(projectId);
        imagesMapper.insertSelective(images);

        //保存详情图
        List<String> detailsImage = redisStorageVo.getDetailsImage();
        detailsImage.forEach((url)->{
            TProjectImages detailImage = new TProjectImages();
            detailImage.setImgurl(url);
            detailImage.setImgtype(ImgTypeEnume.DEATAIL_IMG.getCode());
            detailImage.setProjectid(projectId);
            imagesMapper.insertSelective(detailImage);
        });

        //保存项目标签

        List<Integer> tagids = redisStorageVo.getTagids();
        tagids.forEach((id)->{
            TProjectTag tag = new TProjectTag();
            tag.setId(projectId);
            tag.setTagid(id);
            projectTagMapper.insertSelective(tag);

        });
        //保存项目分类
        List<Integer> typeids = redisStorageVo.getTypeids();
        typeids.forEach((id)->{
            TProjectType type=new TProjectType();
            type.setProjectid(projectId);
            type.setTypeid(id);
            projectTypeMapper.insertSelective(type);
        });

        //项目回报
        List<TReturn> projectReturns = redisStorageVo.getProjectReturns();
        projectReturns.forEach((projectReturn)->{
            projectReturn.setProjectid(projectId);
            returnMapper.insertSelective(projectReturn);

        });

        //指定项目其他默认值
        //项目保存成功，将redis中的删除
        stringRedisTemplate.delete(AppConstant.PROJECT_TEMP_CACHE_PREFIX+vo.getProjectToken());

    }

    @Override
    public void tempProjectToDb(BaseVo vo) {
        saveProject(vo,ProjectStatusEnume.DRAFT);
    }
}
