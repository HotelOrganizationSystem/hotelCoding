package com.hotel.service;

import com.hotel.entity.HotelOrder;
import com.hotel.entity.Rtype;

import java.util.List;
import java.util.Map;

public interface BookRoomService {
    List<Rtype> getTypes(Map<String,Object> maps);

    /**
     *  获取所有的房间类型
     */
    List<Rtype> getAllRType();


    /**
     *  生成订单
     */
    int insert_order(HotelOrder hotelOrder, Integer rtypeId);
}
