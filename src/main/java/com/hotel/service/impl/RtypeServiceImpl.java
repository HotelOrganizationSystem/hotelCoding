package com.hotel.service.impl;

import com.hotel.entity.Rtype;
import com.hotel.dao.RtypeDao;
import com.hotel.service.RtypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客房类型表(Rtype)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:28
 */
@Service("rtypeService")
public class RtypeServiceImpl implements RtypeService {
    @Resource
    private RtypeDao rtypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rtypeid 主键
     * @return 实例对象
     */
    @Override
    public Rtype queryById(Integer rtypeid) {
        return this.rtypeDao.queryById(rtypeid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Rtype> queryAllByLimit(int offset, int limit) {
        return this.rtypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rtype 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Rtype rtype) {
        return this.rtypeDao.insert(rtype);
    }

    /**
     * 修改数据
     *
     * @param rtype 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(Rtype rtype) {
        return this.rtypeDao.update(rtype) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param rtypeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rtypeid) {
        return this.rtypeDao.deleteById(rtypeid) > 0;
    }

    @Override
    public boolean deleteAll(Integer[] rtypeids) {
        boolean flag = true;
        for (Integer rtypeid : rtypeids) {
            if(this.rtypeDao.deleteById(rtypeid) <= 0) flag = false;
        }
        return flag;
    }
}
