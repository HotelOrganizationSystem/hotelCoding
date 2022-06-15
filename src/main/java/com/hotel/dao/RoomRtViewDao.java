package com.hotel.dao;

import com.hotel.entity.RoomRtView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (RoomRtView)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-14 08:52:03
 */
public interface RoomRtViewDao {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    RoomRtView queryById(Integer roomid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<RoomRtView> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roomRtView 实例对象
     * @return 对象列表
     */
    List<RoomRtView> queryAll(RoomRtView roomRtView);

    /**
     * 新增数据
     *
     * @param roomRtView 实例对象
     * @return 影响行数
     */
    int insert(RoomRtView roomRtView);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoomRtView> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RoomRtView> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RoomRtView> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<RoomRtView> entities);

    /**
     * 修改数据
     *
     * @param roomRtView 实例对象
     * @return 影响行数
     */
    int update(RoomRtView roomRtView);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 影响行数
     */
    int deleteById();

}

