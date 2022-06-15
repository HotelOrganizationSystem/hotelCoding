package com.hotel.service.impl;

import com.hotel.entity.HotelOrderView;
import com.hotel.dao.HotelOrderViewDao;
import com.hotel.service.HotelOrderViewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HotelOrderView)表服务实现类
 *
 * @author makejava
 * @since 2021-07-14 09:20:49
 */
@Service("hotelOrderViewService")
public class HotelOrderViewServiceImpl implements HotelOrderViewService {
    @Resource
    private HotelOrderViewDao hotelOrderViewDao;

    /**
     * 通过ID查询单条数据
     *
     * @param 主键
     * @return 实例对象
     */
    @Override
    public HotelOrderView queryById(int id) {
        return this.hotelOrderViewDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<HotelOrderView> queryAllByLimit(int offset, int limit) {
        return this.hotelOrderViewDao.queryAllByLimit(offset, limit);
    }


}
