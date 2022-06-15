package com.hotel.entity;

import java.io.Serializable;

/**
 * (RoomRtView)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:33
 */
public class RoomRtView implements Serializable {
    private static final long serialVersionUID = -47663964003776816L;
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
     * 备注
     */
    private String remark;
    /**
     * 客房类型名
     * 总统套房，特大豪华房，豪华房，商务房，情侣房，钟点房
     */
    private String rtypename;
    /**
     * 价格:大于0
     */
    private Double price;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRtypename() {
        return rtypename;
    }

    public void setRtypename(String rtypename) {
        this.rtypename = rtypename;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

}
