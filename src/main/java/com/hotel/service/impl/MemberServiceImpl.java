package com.hotel.service.impl;

import com.hotel.entity.Member;
import com.hotel.dao.MemberDao;
import com.hotel.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员表(Member)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:24
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
    @Resource
    private MemberDao memberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param memid 主键
     * @return 实例对象
     */
    @Override
    public Member queryById(Integer memid) {
        return this.memberDao.queryById(memid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Member> queryAllByLimit(int offset, int limit) {
        return this.memberDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Member> queryAll(Member member) {
        return memberDao.queryAll(member);
    }

    /**
     * 新增数据
     *
     * @param member 实例对象
     * @return 实例对象
     */
    @Override
    public Member insert(Member member) {
        this.memberDao.insert(member);
        return member;
    }

    /**
     * 修改数据
     *
     * @param member 实例对象
     * @return 实例对象
     */
    @Override
    public Member update(Member member) {
        this.memberDao.update(member);
        return this.queryById(member.getMemid());
    }

    /**
     * 通过主键删除数据
     *
     * @param memid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer memid) {
        return this.memberDao.deleteById(memid) > 0;
    }
}
