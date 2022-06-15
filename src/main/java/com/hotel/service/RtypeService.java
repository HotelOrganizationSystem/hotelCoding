package com.hotel.service;

import com.hotel.entity.Rtype;

import java.util.List;

/**
 * 客房类型表(Rtype)表服务接口
 *
 * @author makejava
 * @since 2021-07-08 16:43:28
 */
public interface RtypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param rtypeid 主键
     * @return 实例对象
     */
    Rtype queryById(Integer rtypeid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Rtype> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param rtype 实例对象
     * @return 返回影响的行数
     */
    int insert(Rtype rtype);

    /**
     * 修改数据
     *
     * @param rtype 实例对象
     * @return 是否成功
     */
    boolean update(Rtype rtype);

    /**
     * 通过主键删除数据
     *
     * @param rtypeid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rtypeid);

    boolean deleteAll(Integer[] toArray);
}
