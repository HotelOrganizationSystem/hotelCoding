package com.hotel.service.impl;

import com.hotel.entity.HotelOrder;
import com.hotel.dao.HotelOrderDao;
import com.hotel.service.HotelOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (HotelOrder)表服务实现类
 *
 * @author makejava
 * @since 2021-07-08 16:43:24
 */
@Service("hotelOrderService")
public class HotelOrderServiceImpl implements HotelOrderService {
    @Resource
    private HotelOrderDao hotelOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param orderid 主键
     * @return 实例对象
     */
    @Override
    public HotelOrder queryById(Integer orderid) {
        return this.hotelOrderDao.queryById(orderid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<HotelOrder> queryAllByLimit(int offset, int limit) {
        return this.hotelOrderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hotelOrder 实例对象
     * @return 影响的行数
     */
    @Override
    public int insert(HotelOrder hotelOrder) {
        return this.hotelOrderDao.insert(hotelOrder);
    }

    /**
     * 修改数据
     *
     * @param hotelOrder 实例对象
     * @return 影响的数据
     */
    @Override
    public int update(HotelOrder hotelOrder) {
        return this.hotelOrderDao.update(hotelOrder);
    }

    /**
     * 通过主键删除数据
     *
     * @param orderid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer orderid) {
        return this.hotelOrderDao.deleteById(orderid) > 0;
    }

    @Override
    public boolean deleteAll(Integer[] orderids) {
        boolean flag = true;
        for (Integer orderid : orderids) {
            if(this.hotelOrderDao.deleteById(orderid) <= 0) flag = false;
        }
        return flag;
    }
}
