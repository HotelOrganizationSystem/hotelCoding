package com.hotel.service.impl;

import com.hotel.entity.UsersDepEmpView;
import com.hotel.dao.UsersDepEmpViewDao;
import com.hotel.service.UsersDepEmpViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UsersDepEmpView)表服务实现类
 *
 * @author makejava
 * @since 2021-07-11 14:12:19
 */
@Service("usersDepEmpViewService")
public class UsersDepEmpViewServiceImpl implements UsersDepEmpViewService {
    @Resource
    private UsersDepEmpViewDao usersDepEmpViewDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public UsersDepEmpView queryById(Integer id) {
        return this.usersDepEmpViewDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UsersDepEmpView> queryAllByLimit(int offset, int limit) {
        return this.usersDepEmpViewDao.queryAllByLimit(offset, limit);
    }




}
