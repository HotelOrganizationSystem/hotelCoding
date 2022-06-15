package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (UsersDepEmpView)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:35
 */
public class UsersDepEmpView implements Serializable {
    private static final long serialVersionUID = -24891138721458997L;
    /**
     * 员工ID
     */
    private Integer empid;
    /**
     * 员工姓名
     */
    private String empname;
    /**
     * 男 or 女
     */
    private String empsex;
    /**
     * 年龄
     */
    private Integer empage;
    /**
     * 员工联系电话
     */
    private String empphone;
    /**
     * 工龄
     */
    private Integer empwage;
    /**
     * 邮箱
     */
    private String empemail;
    /**
     * 薪资
     */
    private Integer emppay;
    /**
     * 最后登录时间
     */
    private Date etime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 部门ID
     */
    private Integer depid;
    /**
     * 部门名称
     */
    private String depname;
    /**
     * 用户ID
     */
    private Integer usersid;
    /**
     * 角色ID
     * 外键 主键表:角色表(role)
     */
    private Integer roleid;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 角色名称
     */
    private String rolename;
    /**
     * 权限列表
     * 存放该角色所具有权限的id字符串（1,2,3,4）
     */
    private String funlist;


    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmpsex() {
        return empsex;
    }

    public void setEmpsex(String empsex) {
        this.empsex = empsex;
    }

    public Integer getEmpage() {
        return empage;
    }

    public void setEmpage(Integer empage) {
        this.empage = empage;
    }

    public String getEmpphone() {
        return empphone;
    }

    public void setEmpphone(String empphone) {
        this.empphone = empphone;
    }

    public Integer getEmpwage() {
        return empwage;
    }

    public void setEmpwage(Integer empwage) {
        this.empwage = empwage;
    }

    public String getEmpemail() {
        return empemail;
    }

    public void setEmpemail(String empemail) {
        this.empemail = empemail;
    }

    public Integer getEmppay() {
        return emppay;
    }

    public void setEmppay(Integer emppay) {
        this.emppay = emppay;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public Integer getUsersid() {
        return usersid;
    }

    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
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

}
