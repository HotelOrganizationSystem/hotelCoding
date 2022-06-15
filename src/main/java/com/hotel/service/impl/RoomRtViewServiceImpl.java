package com.hotel.service.impl;

import com.hotel.entity.RoomRtView;
import com.hotel.dao.RoomRtViewDao;
import com.hotel.service.RoomRtViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (RoomRtView)表服务实现类
 *
 * @author makejava
 * @since 2021-07-14 08:52:03
 */
@Service("roomRtViewService")
public class RoomRtViewServiceImpl implements RoomRtViewService {
    @Resource
    private RoomRtViewDao roomRtViewDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id
     * @return 实例对象
     */
    @Override
    public RoomRtView queryById(int id) {
        return this.roomRtViewDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<RoomRtView> queryAllByLimit(int offset, int limit) {
        return this.roomRtViewDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<RoomRtView> queryAll(RoomRtView roomRtView) {
        return this.roomRtViewDao.queryAll(roomRtView);
    }
}
