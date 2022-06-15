package com.hotel.dao;

import com.hotel.entity.UserMemTypeView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserMemTypeView)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 14:12:16
 */
public interface UserMemTypeViewDao {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    UserMemTypeView queryById(Integer memid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserMemTypeView> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userMemTypeView 实例对象
     * @return 对象列表
     */
    List<UserMemTypeView> queryAll(UserMemTypeView userMemTypeView);

    /**
     * 新增数据
     *
     * @param userMemTypeView 实例对象
     * @return 影响行数
     */
    int insert(UserMemTypeView userMemTypeView);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserMemTypeView> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserMemTypeView> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserMemTypeView> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UserMemTypeView> entities);

    /**
     * 修改数据
     *
     * @param userMemTypeView 实例对象
     * @return 影响行数
     */
    int update(UserMemTypeView userMemTypeView);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 影响行数
     */
    int deleteById();

}

