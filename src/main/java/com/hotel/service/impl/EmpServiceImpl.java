package com.hotel.service.impl;

import com.hotel.entity.Emp;
import com.hotel.dao.EmpDao;
import com.hotel.service.EmpService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工表(Emp)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:23
 */
@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpDao empDao;

    /**
     * 通过ID查询单条数据
     *
     * @param empid 主键
     * @return 实例对象
     */
    @Override
    public Emp queryById(Integer empid) {
        return this.empDao.queryById(empid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Emp> queryAllByLimit(int offset, int limit) {
        return this.empDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public Emp insert(Emp emp) {
        this.empDao.insert(emp);
        return emp;
    }

    /**
     * 修改数据
     *
     * @param emp 实例对象
     * @return 实例对象
     */
    @Override
    public Emp update(Emp emp) {
        this.empDao.update(emp);
        return this.queryById(emp.getEmpid());
    }

    /**
     * 通过主键删除数据
     *
     * @param empid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer empid) {
        return this.empDao.deleteById(empid) > 0;
    }
}
