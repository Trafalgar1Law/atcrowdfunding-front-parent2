package com.atguigu.front.bean;

public class TResource {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_resource.id
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_resource.url
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    private String url;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_resource.createat
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    private String createat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_resource.updateat
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    private String updateat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_resource.id
     *
     * @return the value of t_resource.id
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_resource.id
     *
     * @param id the value for t_resource.id
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_resource.url
     *
     * @return the value of t_resource.url
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_resource.url
     *
     * @param url the value for t_resource.url
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_resource.createat
     *
     * @return the value of t_resource.createat
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public String getCreateat() {
        return createat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_resource.createat
     *
     * @param createat the value for t_resource.createat
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public void setCreateat(String createat) {
        this.createat = createat == null ? null : createat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_resource.updateat
     *
     * @return the value of t_resource.updateat
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public String getUpdateat() {
        return updateat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_resource.updateat
     *
     * @param updateat the value for t_resource.updateat
     *
     * @mbg.generated Fri Jun 21 20:46:39 CST 2019
     */
    public void setUpdateat(String updateat) {
        this.updateat = updateat == null ? null : updateat.trim();
    }
}