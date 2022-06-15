package com.hotel.dao;

import com.hotel.entity.Member;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 会员表(Member)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 16:43:24
 */
public interface MemberDao {

    /**
     * 通过ID查询单条数据
     *
     * @param memid 主键
     * @return 实例对象
     */
    Member queryById(Integer memid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Member> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param member 实例对象
     * @return 对象列表
     */
    List<Member> queryAll(Member member);

    /**
     * 新增数据
     *
     * @param member 实例对象
     * @return 影响行数
     */
    int insert(Member member);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Member> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Member> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Member> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Member> entities);

    /**
     * 修改数据
     *
     * @param member 实例对象
     * @return 影响行数
     */
    int update(Member member);

    /**
     * 通过主键删除数据
     *
     * @param memid 主键
     * @return 影响行数
     */
    int deleteById(Integer memid);

}

