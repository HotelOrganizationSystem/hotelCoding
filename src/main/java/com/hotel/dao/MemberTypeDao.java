package com.hotel.dao;

import com.hotel.entity.MemberType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员类型表(MemberType)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 16:43:25
 */
public interface MemberTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param memTypeId 主键
     * @return 实例对象
     */
    MemberType queryById(Integer memTypeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MemberType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param memberType 实例对象
     * @return 对象列表
     */
    List<MemberType> queryAll(MemberType memberType);

    /**
     * 新增数据
     *
     * @param memberType 实例对象
     * @return 影响行数
     */
    int insert(MemberType memberType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<MemberType> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<MemberType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<MemberType> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<MemberType> entities);

    /**
     * 修改数据
     *
     * @param memberType 实例对象
     * @return 影响行数
     */
    int update(MemberType memberType);

    /**
     * 通过主键删除数据
     *
     * @param memTypeId 主键
     * @return 影响行数
     */
    int deleteById(Integer memTypeId);

}

