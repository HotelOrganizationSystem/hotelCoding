package com.hotel.service.impl;

import com.hotel.entity.Users;
import com.hotel.dao.UsersDao;
import com.hotel.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户表(Users)表服务实现类
 *
 * @author makejava
 * @since 2021-07-09 09:52:55
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param usersid 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer usersid) {
        return this.usersDao.queryById(usersid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Users> queryAllByLimit(int offset, int limit) {
        return this.usersDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Users> queryAll(Users users) {
        return usersDao.queryAll(users);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getUsersid());
    }

    /**
     * 通过主键删除数据
     *
     * @param usersid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer usersid) {
        return this.usersDao.deleteById(usersid) > 0;
    }

    @Override
    public boolean deleteAll(Integer[] users) {
        boolean flag = true;
        for (Integer usersid : users) {
            if(this.usersDao.deleteById(usersid) <= 0) flag = false;
        }
        return flag;
    }
}
