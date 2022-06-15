package com.hotel.entity;

import java.io.Serializable;

/**
 * 角色表(Role)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:14
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 541068213619143396L;
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
     * 备注
     */
    private String remark;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
