package com.hotel.service.impl;

import com.hotel.dao.HotelOrderDao;
import com.hotel.dao.RoomDao;
import com.hotel.dao.RoomRtViewDao;
import com.hotel.dao.RtypeDao;
import com.hotel.entity.HotelOrder;
import com.hotel.entity.Room;
import com.hotel.entity.RoomRtView;
import com.hotel.entity.Rtype;
import com.hotel.service.BookRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("bookRoomService")
public class BookRoomServiceImpl implements BookRoomService {

   @Resource
   private RtypeDao rtypeDao;
    @Resource
    private HotelOrderDao hotelOrderDao;

   @Resource
    private RoomDao roomDao;

   @Resource
   private RoomRtViewDao roomRtViewDao;
    @Override
    public List<Rtype> getTypes(Map<String, Object> maps) {
        return rtypeDao.getTypes(maps);
    }

    @Override
    public List<Rtype> getAllRType() {
        return rtypeDao.queryAll(new Rtype());
    }

    @Override
    @Transactional(rollbackFor = {Exception.class}
            , propagation = Propagation.REQUIRED)
    public int insert_order(HotelOrder hotelOrder, Integer rtypeId) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("rtypeId", rtypeId);

        Rtype rtype = getTypes(maps).get(0);

        int insert = -1;
        RoomRtView roomRtView = new RoomRtView();
        roomRtView.setRtypeid(rtypeId);
        if (roomRtViewDao.queryAll(roomRtView ).size() > 0) {
            Room room = new Room();
            room.setRtypeid(rtypeId);
            room.setIsres(0);
            Room feeRoom = roomDao.queryAll(room).get(0);

            synchronized (feeRoom) {
                if (roomDao.queryAll(room).get(0) == null) return -1;

                hotelOrder.setRoomid(feeRoom.getRoomid());
                hotelOrder.setOrderstate("未审核");
                insert = hotelOrderDao.insert(hotelOrder);
                feeRoom.setIsres(1); // 入住
                roomDao.update(feeRoom);
            }
        }

        return insert;
    }
}
