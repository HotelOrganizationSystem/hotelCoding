package com.hotel.dao;

import com.hotel.entity.UsersDepEmpView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UsersDepEmpView)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-11 14:12:18
 */
public interface UsersDepEmpViewDao {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    UsersDepEmpView queryById(int empid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UsersDepEmpView> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param usersDepEmpView 实例对象
     * @return 对象列表
     */
    List<UsersDepEmpView> queryAll(UsersDepEmpView usersDepEmpView);

    /**
     * 新增数据
     *
     * @param usersDepEmpView 实例对象
     * @return 影响行数
     */
    int insert(UsersDepEmpView usersDepEmpView);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UsersDepEmpView> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UsersDepEmpView> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UsersDepEmpView> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UsersDepEmpView> entities);

    /**
     * 修改数据
     *
     * @param usersDepEmpView 实例对象
     * @return 影响行数
     */
    int update(UsersDepEmpView usersDepEmpView);

    /**
     * 通过主键删除数据
     *
     * @param 主键
     * @return 影响行数
     */
    int deleteById();

}

