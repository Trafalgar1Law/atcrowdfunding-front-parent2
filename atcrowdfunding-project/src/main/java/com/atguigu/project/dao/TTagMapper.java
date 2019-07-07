package com.atguigu.project.dao;

import com.atguigu.front.bean.TTag;
import com.atguigu.front.bean.TTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    long countByExample(TTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int deleteByExample(TTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int insert(TTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int insertSelective(TTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    List<TTag> selectByExample(TTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    TTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByExampleSelective(@Param("record") TTag record, @Param("example") TTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByExample(@Param("record") TTag record, @Param("example") TTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByPrimaryKeySelective(TTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_tag
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    int updateByPrimaryKey(TTag record);
}