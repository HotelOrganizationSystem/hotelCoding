package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工表(Emp)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:08
 */
public class Emp implements Serializable {
    private static final long serialVersionUID = 991493166424609006L;
    /**
     * 员工ID
     */
    private Integer empid;
    /**
     * 部门ID
     * 外键 主键表:部门表（dep
     */
    private Integer depid;
    /**
     * 用户ID
     */
    private Integer usersid;
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


    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getDepid() {
        return depid;
    }

    public void setDepid(Integer depid) {
        this.depid = depid;
    }

    public Integer getUsersid() {
        return usersid;
    }

    public void setUsersid(Integer usersid) {
        this.usersid = usersid;
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

}
