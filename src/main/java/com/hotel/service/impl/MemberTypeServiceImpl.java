package com.hotel.service.impl;

import com.hotel.entity.MemberType;
import com.hotel.dao.MemberTypeDao;
import com.hotel.service.MemberTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员类型表(MemberType)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:25
 */
@Service("memberTypeService")
public class MemberTypeServiceImpl implements MemberTypeService {
    @Resource
    private MemberTypeDao memberTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param memTypeId 主键
     * @return 实例对象
     */
    @Override
    public MemberType queryById(Integer memTypeId) {
        return this.memberTypeDao.queryById(memTypeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MemberType> queryAllByLimit(int offset, int limit) {
        return this.memberTypeDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<MemberType> queryAll(MemberType memberType) {
        return memberTypeDao.queryAll(memberType);
    }

    /**
     * 新增数据
     *
     * @param memberType 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(MemberType memberType) {
        return this.memberTypeDao.insert(memberType);
    }

    /**
     * 修改数据
     *
     * @param memberType 实例对象
     * @return 实例对象
     */
    @Override
    public boolean update(MemberType memberType) {
        return memberTypeDao.update(memberType)>0;
    }

    /**
     * 通过主键删除数据
     *
     * @param memTypeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer memTypeId) {
        return this.memberTypeDao.deleteById(memTypeId) > 0;
    }

    @Override
    public boolean deleteAll(Integer[] memTypeIds) {
        boolean flag = true;
        for (Integer memTId : memTypeIds) {
            if(this.memberTypeDao.deleteById(memTId) <= 0) flag = false;
        }
        return flag;
    }
}
