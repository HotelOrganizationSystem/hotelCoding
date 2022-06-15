package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (HotelOrder)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:09
 */
public class HotelOrder implements Serializable {
    private static final long serialVersionUID = 840792938054870369L;
    /**
     * 订单ID
     */
    private Integer orderid;
    /**
     * 会员ID
     * 外键 主键表：会员表（member）
     */
    private Integer memid;
    /**
     * 客房ID
     * 外键 主键表：客房表（room）
     */
    private Integer roomid;
    /**
     * 订单状态
     * 未审核，已审核，已取消，已入住
     */
    private String orderstate;
    /**
     * 定金
     * 从所定的房间所属类型表里来
     */
    private Integer deposit;
    /**
     * 价格
     */
    private Double price;
    /**
     * 下单时间
     */
    private Date ordertime;
    /**
     * 人数
     */
    private Integer personnum;
    /**
     * 入住时间
     */
    private Date intime;
    /**
     * 离开时间
     */
    private Date outtime;
    /**
     * 备注
     */
    private String remark;


    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getMemid() {
        return memid;
    }

    public void setMemid(Integer memid) {
        this.memid = memid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(String orderstate) {
        this.orderstate = orderstate;
    }

    public Integer getDeposit() {
        return deposit;
    }

    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getPersonnum() {
        return personnum;
    }

    public void setPersonnum(Integer personnum) {
        this.personnum = personnum;
    }

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Date outtime) {
        this.outtime = outtime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
