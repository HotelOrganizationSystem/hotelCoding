package com.hotel.service;

import com.hotel.entity.UsersDepEmpView;

import java.util.List;

/**
 * (UsersDepEmpView)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 14:12:18
 */
public interface UsersDepEmpViewService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    UsersDepEmpView queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UsersDepEmpView> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param usersDepEmpView 实例对象
     * @return 实例对象
     */


}
