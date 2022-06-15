package com.hotel.service.impl;

import com.hotel.entity.Dep;
import com.hotel.dao.DepDao;
import com.hotel.service.DepService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表(Dep)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:19
 */
@Service("depService")
public class DepServiceImpl implements DepService {
    @Resource
    private DepDao depDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depid 主键
     * @return 实例对象
     */
    @Override
    public Dep queryById(Integer depid) {
        return this.depDao.queryById(depid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Dep> queryAllByLimit(int offset, int limit) {
        return this.depDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dep 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Dep dep) {
        return this.depDao.insert(dep);
    }

    /**
     * 修改数据
     *
     * @param dep 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Dep dep) {
        return this.depDao.update(dep) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param depid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depid) {
        return this.depDao.deleteById(depid) > 0;
    }

    @Override
    public boolean deleteByIds(Integer[] depids) {
        boolean flag = true;
        for (Integer depid : depids) {
            if(this.depDao.deleteById(depid) <= 0) flag = false;
        }
        return flag;
    }
}
