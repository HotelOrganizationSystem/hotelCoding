package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (UserMemTypeView)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:34
 */
public class UserMemTypeView implements Serializable {
    private static final long serialVersionUID = 304787015524159199L;
    /**
     * 会员ID
     */
    private Integer memid;
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
     * 用户ID
     */
    private Integer usersid;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色ID
     */
    private Integer roleid;
    /**
     * 角色名称
     */
    private String rolename;
    /**
     * 权限列表
     * 存放该角色所具有权限的id字符串（1,2,3,4）
     */
    private String funlist;
    /**
     * 会员类型ID
     */
    private Integer memTypeId;
    /**
     * 会员类型名
     */
    private String memtype;
    /**
     * 订房折扣,格式：0.75
     */
    private Double discount;


    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
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

    public Integer getUsersid() {
        return usersid;
    }

    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getFunlist() {
        return funlist;
    }

    public void setFunlist(String funlist) {
        this.funlist = funlist;
    }

    public Integer getMemTypeId() {
        return memTypeId;
    }

    public void setMemTypeId(Integer memTypeId) {
        this.memTypeId = memTypeId;
    }

    public String getMemtype() {
        return memtype;
    }

    public void setMemtype(String memtype) {
        this.memtype = memtype;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "UserMemTypeView{" +
                "memid=" + memid +
                ", memname='" + memname + '\'' +
                ", phone='" + phone + '\'' +
                ", memsex='" + memsex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", email='" + email + '\'' +
                ", memint=" + memint +
                ", regisdate=" + regisdate +
                ", userstate='" + userstate + '\'' +
                ", remark='" + remark + '\'' +
                ", usersid=" + usersid +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", funlist='" + funlist + '\'' +
                ", memTypeId=" + memTypeId +
                ", memtype='" + memtype + '\'' +
                ", discount=" + discount +
                '}';
    }
}
