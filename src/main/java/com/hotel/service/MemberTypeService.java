package com.hotel.service;

import com.hotel.entity.MemberType;

import java.util.List;

/**
 * 会员类型表(MemberType)表服务接口
 *
 * @author makejava
 * @since 2021-07-08 16:43:25
 */
public interface MemberTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param memTypeId 主键
     * @return 实例对象
     */
    MemberType queryById(Integer memTypeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MemberType> queryAllByLimit(int offset, int limit);

    List<MemberType> queryAll(MemberType memberType);

    /**
     * 新增数据
     *
     * @param memberType 实例对象
     * @return 实例对象
     */
    int insert(MemberType memberType);

    /**
     * 修改数据
     *
     * @param memberType 实例对象
     * @return 实例对象
     */
    boolean update(MemberType memberType);

    /**
     * 通过主键删除数据
     *
     * @param memTypeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer memTypeId);

    boolean deleteAll(Integer[] memTypeIds);
}
