package com.hotel.service.impl;

import com.hotel.entity.Room;
import com.hotel.dao.RoomDao;
import com.hotel.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客房表(Room)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:27
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
    @Resource
    private RoomDao roomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roomid 主键
     * @return 实例对象
     */
    @Override
    public Room queryById(Integer roomid) {
        return this.roomDao.queryById(roomid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Room> queryAllByLimit(int offset, int limit) {
        return this.roomDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<Room> queryAll(Room room) {
        return roomDao.queryAll(room);
    }

    /**
     * 新增数据
     *
     * @param room 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Room room) {
        return this.roomDao.insert(room);
    }

    /**
     * 修改数据
     *
     * @param room 实例对象
     * @return 是否成功
     */
    @Override
    public boolean update(Room room) {
        return this.roomDao.update(room) > 0;
    }

    /**
     * 通过主键删除数据
     *
     * @param roomid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roomid) {
        return this.roomDao.deleteById(roomid) > 0;
    }

    @Override
    public boolean deleteAll(Integer[] roomids) {
        boolean flag = true;
        for (Integer roomid : roomids) {
            if(this.roomDao.deleteById(roomid) <= 0) flag = false;
        }
        return flag;
    }
}
