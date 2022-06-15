package com.hotel.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (HotelOrderView)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:32
 */
public class HotelOrderView implements Serializable {
    private static final long serialVersionUID = 711149366222842999L;
    /**
     * 订单ID
     */
    private Integer orderid;
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
    private Double oPrice;
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
     * 会员类型名
     */
    private String memtype;
    /**
     * 订房折扣,格式：0.75
     */
    private Double discount;
    /**
     * 客房ID
     */
    private Integer roomid;
    /**
     * 房间号
     */
    private String roomNum;
    /**
     * 客房类型ID
     * 外键 主键表 客房类型表（rtype）
     */
    private Integer rtypeid;
    /**
     * 是否可预定
     * 0(可以)，1（不可以）
     */
    private Integer isres;
    /**
     * 状态
     */
    private String state;
    /**
     * 客房类型名
     * 总统套房，特大豪华房，豪华房，商务房，情侣房，钟点房
     */
    private String rtypename;
    /**
     * 价格:大于0
     */
    private Double rPrice;
    /**
     * 居住人数
     */
    private Integer livenum;
    /**
     * 基础设施:如：“风扇，桌子“
     */
    private String facility;
    /**
     * 预定金额
     */
    private Double resmoney;
    /**
     * 是否有宽带
     * 0(可以)，1（不可以）
     */
    private Integer isnet;
    /**
     * 是否提供早餐
     * 0(可以)，1（不可以）
     */
    private Integer isfoot;
    /**
     * 默认图片url
     */
    private String defimg;


    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public Double getOPrice() {
        return oPrice;
    }

    public void setOPrice(Double oPrice) {
        this.oPrice = oPrice;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public Integer getRtypeid() {
        return rtypeid;
    }

    public void setRtypeid(Integer rtypeid) {
        this.rtypeid = rtypeid;
    }

    public Integer getIsres() {
        return isres;
    }

    public void setIsres(Integer isres) {
        this.isres = isres;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRtypename() {
        return rtypename;
    }

    public void setRtypename(String rtypename) {
        this.rtypename = rtypename;
    }

    public Double getRPrice() {
        return rPrice;
    }

    public void setRPrice(Double rPrice) {
        this.rPrice = rPrice;
    }

    public Integer getLivenum() {
        return livenum;
    }

    public void setLivenum(Integer livenum) {
        this.livenum = livenum;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public Double getResmoney() {
        return resmoney;
    }

    public void setResmoney(Double resmoney) {
        this.resmoney = resmoney;
    }

    public Integer getIsnet() {
        return isnet;
    }

    public void setIsnet(Integer isnet) {
        this.isnet = isnet;
    }

    public Integer getIsfoot() {
        return isfoot;
    }

    public void setIsfoot(Integer isfoot) {
        this.isfoot = isfoot;
    }

    public String getDefimg() {
        return defimg;
    }

    public void setDefimg(String defimg) {
        this.defimg = defimg;
    }

    @Override
    public String toString() {
        return "HotelOrderView{" +
                "orderid=" + orderid +
                ", orderstate='" + orderstate + '\'' +
                ", deposit=" + deposit +
                ", oPrice=" + oPrice +
                ", ordertime=" + ordertime +
                ", personnum=" + personnum +
                ", intime=" + intime +
                ", outtime=" + outtime +
                ", remark='" + remark + '\'' +
                ", memid=" + memid +
                ", usersid=" + usersid +
                ", memTypeId=" + memTypeId +
                ", memname='" + memname + '\'' +
                ", phone='" + phone + '\'' +
                ", memsex='" + memsex + '\'' +
                ", idcard='" + idcard + '\'' +
                ", email='" + email + '\'' +
                ", memint=" + memint +
                ", regisdate=" + regisdate +
                ", userstate='" + userstate + '\'' +
                ", memtype='" + memtype + '\'' +
                ", discount=" + discount +
                ", roomid=" + roomid +
                ", roomNum='" + roomNum + '\'' +
                ", rtypeid=" + rtypeid +
                ", isres=" + isres +
                ", state='" + state + '\'' +
                ", rtypename='" + rtypename + '\'' +
                ", rPrice=" + rPrice +
                ", livenum=" + livenum +
                ", facility='" + facility + '\'' +
                ", resmoney=" + resmoney +
                ", isnet=" + isnet +
                ", isfoot=" + isfoot +
                ", defimg='" + defimg + '\'' +
                '}';
    }
}
