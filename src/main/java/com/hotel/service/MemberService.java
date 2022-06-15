package com.hotel.service;

import com.hotel.entity.Member;

import java.util.List;

/**
 * 会员表(Member)表服务接口
 *
 * @author makejava
 * @since 2021-07-08 16:43:24
 */
public interface MemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param memid 主键
     * @return 实例对象
     */
    Member queryById(Integer memid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Member> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param member 实例对象
     * @return 实例对象
     */

    List<Member> queryAll(Member member);

    Member insert(Member member);

    /**
     * 修改数据
     *
     * @param member 实例对象
     * @return 实例对象
     */
    Member update(Member member);

    /**
     * 通过主键删除数据
     *
     * @param memid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer memid);

}
