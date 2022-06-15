package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 会员表(Member)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:10
 */
public class Member implements Serializable {
    private static final long serialVersionUID = 612112543791385791L;
    /**
     * 会员ID
     */
    private Integer memid;
    /**
     * 用户ID
     */
    private Integer usersid;
    /**
     * 会员ID
     */
    private Integer memTypeId;
    /**
     * 会员姓名
     */
    private String memname;
    /**
     * 手机
     */
    private String phone;
    /**
     * 性别
     */
    private String memsex;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 积分
     */
    private Integer memint;
    /**
     * 注册时间
     */
    private Date regisdate;
    /**
     * 用户状态
     */
    private String userstate;
    /**
     * 备注
     */
    private String remark;

    /**
     * 增加耦合，无法与数据
     */
    private MemberType memberType;

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getUsersid() {
        return usersid;
    }

    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }

    public Integer getMemTypeId() {
        return memTypeId;
    }

    public void setMemTypeId(Integer memTypeId) {
        this.memTypeId = memTypeId;
    }

    public String getMemname() {
        return memname;
    }

    public void setMemname(String memname) {
        this.memname = memname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemsex() {
        return memsex;
    }

    public void setMemsex(String memsex) {
        this.memsex = memsex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMemint() {
        return memint;
    }

    public void setMemint(Integer memint) {
        this.memint = memint;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getRegisdate() {
        return regisdate;
    }

    public void setRegisdate(Date regisdate) {
        this.regisdate = regisdate;
    }

    public String getUserstate() {
        return userstate;
    }

    public void setUserstate(String userstate) {
        this.userstate = userstate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
