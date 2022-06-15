package com.hotel.service;

import com.hotel.entity.Dep;

import java.util.List;

/**
 * 部门表(Dep)表服务接口
 *
 * @author makejava
 * @since 2021-07-08 16:43:18
 */
public interface DepService {

    /**
     * 通过ID查询单条数据
     *
     * @param depid 主键
     * @return 实例对象
     */
    Dep queryById(Integer depid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dep> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dep 实例对象
     * @return 返回影响的行数
     */
     int insert(Dep dep);

    /**
     * 修改数据
     *
     * @param dep 实例对象
     * @return 是否成功
     */
    boolean update(Dep dep);

    /**
     * 通过主键删除数据
     *
     * @param depid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer depid);

    boolean deleteByIds(Integer[] depids);

}
