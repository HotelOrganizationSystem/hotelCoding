package com.hotel.dao;

import com.hotel.entity.Rtype;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客房类型表(Rtype)表数据库访问层
 *
 * @author makejava
 * @since 2021-07-08 16:43:28
 */
public interface RtypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rtypeid 主键
     * @return 实例对象
     */
    Rtype queryById(Integer rtypeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Rtype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param rtype 实例对象
     * @return 对象列表
     */
    List<Rtype> queryAll(Rtype rtype);

    /**
     * 新增数据
     *
     * @param rtype 实例对象
     * @return 影响行数
     */

    /**
     *  筛选所有的房间类型
     */
    List<Rtype> getTypes(Map<String,Object> map);

    int insert(Rtype rtype);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Rtype> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Rtype> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Rtype> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Rtype> entities);

    /**
     * 修改数据
     *
     * @param rtype 实例对象
     * @return 影响行数
     */
    int update(Rtype rtype);

    /**
     * 通过主键删除数据
     *
     * @param rtypeid 主键
     * @return 影响行数
     */
    int deleteById(Integer rtypeid);

}

