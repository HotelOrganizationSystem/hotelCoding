package com.hotel.service;

import com.hotel.entity.Room;

import java.util.List;

/**
 * 客房表(Room)表服务接口
 *
 * @author makejava
 * @since 2021-07-08 16:43:27
 */
public interface RoomService {

    /**
     * 通过ID查询单条数据
     *
     * @param roomid 主键
     * @return 实例对象
     */
    Room queryById(Integer roomid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Room> queryAllByLimit(int offset, int limit);


    List<Room> queryAll(Room room);
    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 返回影响的行数
     */
    int insert(Room room);

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 是否成功
     */
    boolean update(Room room);

    /**
     * 通过主键删除数据
     *
     * @param roomid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roomid);

    boolean deleteAll(Integer[] roomids);
}
