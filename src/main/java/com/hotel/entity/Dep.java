package com.hotel.entity;

import java.io.Serializable;

/**
 * 部门表(Dep)实体类
 *
 * @author ling
 * @since 2021-07-14 10:10:07
 */
public class Dep implements Serializable {
    private static final long serialVersionUID = -62136589542352912L;
    /**
     * 部门ID
     */
    private Integer depid;
    /**
     * 部门名称
     */
    private String depname;
    /**
     * 备注
     */
    private String remark;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
