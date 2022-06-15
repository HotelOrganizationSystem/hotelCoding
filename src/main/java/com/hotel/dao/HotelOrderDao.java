package com.hotel.dao;

import com.hotel.entity.HotelOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (HotelOrder)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 16:43:23
 */
public interface HotelOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    HotelOrder queryById(Integer orderid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<HotelOrder> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param hotelOrder 实例对象
     * @return 对象列表
     */
    List<HotelOrder> queryAll(HotelOrder hotelOrder);

    /**
     * 新增数据
     *
     * @param hotelOrder 实例对象
     * @return 影响行数
     */
    int insert(HotelOrder hotelOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<HotelOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<HotelOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<HotelOrder> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<HotelOrder> entities);

    /**
     * 修改数据
     *
     * @param hotelOrder 实例对象
     * @return 影响行数
     */
    int update(HotelOrder hotelOrder);

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 影响行数
     */
    int deleteById(Integer orderid);

}

