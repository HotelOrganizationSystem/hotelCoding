package com.hotel.service;

import com.hotel.entity.HotelOrderView;

import java.util.List;

/**
 * (HotelOrderView)表服务接口
 *
 * @author makejava
 * @since 2021-07-14 09:20:49
 */
public interface HotelOrderViewService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    HotelOrderView queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HotelOrderView> queryAllByLimit(int offset, int limit);

}
