package com.hotel.dao;

import com.hotel.entity.Dep;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 部门表(Dep)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 16:43:18
 */
@Component
public interface DepDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depid 主键
     * @return 实例对象
     */
    Dep queryById(Integer depid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dep> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dep 实例对象
     * @return 对象列表
     */
    List<Dep> queryAll(Dep dep);

    /**
     * 新增数据
     *
     * @param dep 实例对象
     * @return 影响行数
     */
    int insert(Dep dep);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dep> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dep> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dep> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Dep> entities);

    /**
     * 修改数据
     *
     * @param dep 实例对象
     * @return 影响行数
     */
    int update(Dep dep);

    /**
     * 通过主键删除数据
     *
     * @param depid 主键
     * @return 影响行数
     */
    int deleteById(Integer depid);

}

