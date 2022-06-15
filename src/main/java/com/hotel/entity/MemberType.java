package com.hotel.entity;

import java.io.Serializable;

/**
 * 会员类型表(MemberType)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:12
 */
public class MemberType implements Serializable {
    private static final long serialVersionUID = -55735294178014194L;
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
    /**
     * 备注
     */
    private String remark;


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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
