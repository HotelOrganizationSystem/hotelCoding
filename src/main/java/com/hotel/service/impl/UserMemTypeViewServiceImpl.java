package com.hotel.service.impl;

import com.hotel.entity.UserMemTypeView;
import com.hotel.dao.UserMemTypeViewDao;
import com.hotel.service.UserMemTypeViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UserMemTypeView)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 14:12:17
 */
@Service("userMemTypeViewService")
public class UserMemTypeViewServiceImpl implements UserMemTypeViewService {
    @Resource
    private UserMemTypeViewDao userMemTypeViewDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public UserMemTypeView queryById(Integer id) {
        return this.userMemTypeViewDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UserMemTypeView> queryAllByLimit(int offset, int limit) {
        return this.userMemTypeViewDao.queryAllByLimit(offset, limit);
    }

}
