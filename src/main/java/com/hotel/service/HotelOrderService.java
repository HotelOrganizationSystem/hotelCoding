package com.hotel.service;

import com.hotel.entity.HotelOrder;

import java.util.List;

/**
 * (HotelOrder)表服务接口
 *
 * @author makejava
 * @since 2021-07-08 16:43:23
 */
public interface HotelOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    HotelOrder queryById(Integer orderid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HotelOrder> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param hotelOrder 实例对象
     * @return 影响的行数
     */
    int insert(HotelOrder hotelOrder);

    /**
     * 修改数据
     *
     * @param hotelOrder 实例对象
     * @return 影响的行数
     */
    int update(HotelOrder hotelOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer orderid);

    boolean deleteAll(Integer[] toArray);
}
