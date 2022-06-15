package com.hotel.service;

import com.hotel.entity.RoomRtView;

import java.util.List;

/**
 * (RoomRtView)表服务接口
 *
 * @author makejava
 * @since 2021-07-14 08:52:03
 */
public interface RoomRtViewService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @param id
     * @return 实例对象
     */
    RoomRtView queryById(int id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<RoomRtView> queryAllByLimit(int offset, int limit);


    List<RoomRtView> queryAll(RoomRtView roomRtView);
}
