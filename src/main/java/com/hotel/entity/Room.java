package com.hotel.entity;

import java.io.Serializable;

/**
 * 客房表(Room)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:15
 */
public class Room implements Serializable {
    private static final long serialVersionUID = 409365566654751024L;
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

}
