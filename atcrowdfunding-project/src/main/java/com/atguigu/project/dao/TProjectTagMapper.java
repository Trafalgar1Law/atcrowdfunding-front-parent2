package com.atguigu.project.dao;

import com.atguigu.front.bean.TProjectTag;
import com.atguigu.front.bean.TProjectTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TProjectTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    long countByExample(TProjectTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int deleteByExample(TProjectTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int insert(TProjectTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int insertSelective(TProjectTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    List<TProjectTag> selectByExample(TProjectTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    TProjectTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") TProjectTag record, @Param("example") TProjectTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByExample(@Param("record") TProjectTag record, @Param("example") TProjectTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByPrimaryKeySelective(TProjectTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_project_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByPrimaryKey(TProjectTag record);
}