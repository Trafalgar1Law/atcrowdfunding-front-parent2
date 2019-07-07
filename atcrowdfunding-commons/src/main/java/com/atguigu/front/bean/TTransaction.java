package com.atguigu.front.bean;

public class TTransaction {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.id
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.ordersn
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String ordersn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.paysn
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String paysn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.memberid
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private Integer memberid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.amount
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private Float amount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.paystate
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private Byte paystate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.source
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.status
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.completiontime
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String completiontime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.note
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String note;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.createat
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String createat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_transaction.updateat
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    private String updateat;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.id
     *
     * @return the value of t_transaction.id
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.id
     *
     * @param id the value for t_transaction.id
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.ordersn
     *
     * @return the value of t_transaction.ordersn
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getOrdersn() {
        return ordersn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.ordersn
     *
     * @param ordersn the value for t_transaction.ordersn
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setOrdersn(String ordersn) {
        this.ordersn = ordersn == null ? null : ordersn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.paysn
     *
     * @return the value of t_transaction.paysn
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getPaysn() {
        return paysn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.paysn
     *
     * @param paysn the value for t_transaction.paysn
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setPaysn(String paysn) {
        this.paysn = paysn == null ? null : paysn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.memberid
     *
     * @return the value of t_transaction.memberid
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public Integer getMemberid() {
        return memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.memberid
     *
     * @param memberid the value for t_transaction.memberid
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setMemberid(Integer memberid) {
        this.memberid = memberid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.amount
     *
     * @return the value of t_transaction.amount
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public Float getAmount() {
        return amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.amount
     *
     * @param amount the value for t_transaction.amount
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.paystate
     *
     * @return the value of t_transaction.paystate
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public Byte getPaystate() {
        return paystate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.paystate
     *
     * @param paystate the value for t_transaction.paystate
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setPaystate(Byte paystate) {
        this.paystate = paystate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.source
     *
     * @return the value of t_transaction.source
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.source
     *
     * @param source the value for t_transaction.source
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.status
     *
     * @return the value of t_transaction.status
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.status
     *
     * @param status the value for t_transaction.status
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.completiontime
     *
     * @return the value of t_transaction.completiontime
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getCompletiontime() {
        return completiontime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.completiontime
     *
     * @param completiontime the value for t_transaction.completiontime
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setCompletiontime(String completiontime) {
        this.completiontime = completiontime == null ? null : completiontime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.note
     *
     * @return the value of t_transaction.note
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getNote() {
        return note;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.note
     *
     * @param note the value for t_transaction.note
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.createat
     *
     * @return the value of t_transaction.createat
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getCreateat() {
        return createat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.createat
     *
     * @param createat the value for t_transaction.createat
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setCreateat(String createat) {
        this.createat = createat == null ? null : createat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_transaction.updateat
     *
     * @return the value of t_transaction.updateat
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public String getUpdateat() {
        return updateat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_transaction.updateat
     *
     * @param updateat the value for t_transaction.updateat
     *
     * @mbg.generated Fri Jun 21 20:46:40 CST 2019
     */
    public void setUpdateat(String updateat) {
        this.updateat = updateat == null ? null : updateat.trim();
    }
}