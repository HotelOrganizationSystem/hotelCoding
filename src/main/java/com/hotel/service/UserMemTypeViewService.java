package com.hotel.service;

import com.hotel.entity.UserMemTypeView;

import java.util.List;

/**
 * (UserMemTypeView)表服务接口
 *
 * @author makejava
 * @since 2021-07-11 14:12:17
 */
public interface UserMemTypeViewService {

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @param id
     * @return 实例对象
     */
    UserMemTypeView queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UserMemTypeView> queryAllByLimit(int offset, int limit);



}
