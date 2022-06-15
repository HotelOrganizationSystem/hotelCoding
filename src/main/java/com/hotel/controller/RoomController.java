package com.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.tools.Page;
import com.hotel.entity.Room;
import com.hotel.entity.RoomRtView;
import com.hotel.service.RoomRtViewService;
import com.hotel.service.RoomService;
import com.hotel.service.RtypeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 客房表(Room)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:27
 */
@RestController
@RequestMapping("room")
public class RoomController {
    /**
     * 服务对象
     */
    @Resource
    private RoomService roomService;

    @Resource
    private RtypeService rtypeService;

    @Resource
    private RoomRtViewService roomRtViewService;


    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String RoomList(int page, int limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<RoomRtView> rooms = roomRtViewService.queryAllByLimit(0 + (page - 1) * limit, limit);
        Page<RoomRtView> roomPage = new Page<RoomRtView>();
        roomPage.setCode(0);
        roomPage.setMsg("");
        roomPage.setCount(roomService.queryAllByLimit(0, 10000).size());
        roomPage.setData(rooms);
        String s = mapper.writeValueAsString(roomPage);

        return s;
    }

    @RequestMapping("/gotoAdd")
    public ModelAndView gotoRoomone() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("rtype", rtypeService.queryAllByLimit(0, 10000));
        mv.setViewName("jsp/room/roomAdd");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/add")
    public int addRoomone(@RequestBody Room room) {
        return roomService.insert(room);
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteRoomOne(int roomid) {
        return roomService.deleteById(roomid);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAll", produces =
            "application/json;charset=utf-8")
    public boolean deleteRoomAll(@RequestBody String roomids) throws IOException {
        roomids = "[" + roomids + "]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(roomids, javaType);
        return roomService.deleteAll(list.toArray(new Integer[list.size()]));
    }

    @RequestMapping("/gotoEdit")
    public ModelAndView editRoomone(int roomid, int rtypeid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("rtype", rtypeService.queryAllByLimit(0, 10000));
        mv.addObject("room", roomService.queryById(roomid));
        mv.setViewName("jsp/room/roomEdit");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public boolean updateRoomone(@RequestBody Room room) {
        return roomService.update(room);
    }

    @ResponseBody
    @RequestMapping("/roomNumCheck")
    public boolean roomNumCheck(String roomNum) {
        Room room = new Room();
        room.setRoomNum(roomNum);
        return (roomService.queryAll(room).size() == 0);
    }
}
