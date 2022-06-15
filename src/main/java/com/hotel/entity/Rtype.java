package com.hotel.entity;

import org.springframework.web.multipart.MultipartFile;



/**
 * 客房类型表(Rtype)实体类
 *
 * @author makejava
 * @since 2021-07-14 10:10:16
 */
public class Rtype {
    /**
     * 客房类型ID
     */
    private Integer rtypeid;
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
    /**
     * 备注
     */
    private String remark;

    /**
     * 储存照片的临时文件，不做持久化
     */
    private MultipartFile file;

    /**
     * 剩余可预订的房价数量
     */
    private Integer remainNum;
    public Rtype() {
    }

    public Rtype(Integer rtypeid, String rtypename, Double price, Integer livenum, String facility, Double resmoney, Integer isnet, Integer isfoot, String defimg, String remark, MultipartFile file) {
        this.rtypeid = rtypeid;
        this.rtypename = rtypename;
        this.price = price;
        this.livenum = livenum;
        this.facility = facility;
        this.resmoney = resmoney;
        this.isnet = isnet;
        this.isfoot = isfoot;
        this.defimg = defimg;
        this.remark = remark;
        this.file = file;
    }



    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Integer getRtypeid() {
        return rtypeid;
    }

    public void setRtypeid(Integer rtypeid) {
        this.rtypeid = rtypeid;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRemainNum() {
        return remainNum;
    }

    public void setRemainNum(Integer remainNum) {
        this.remainNum = remainNum;
    }


}
