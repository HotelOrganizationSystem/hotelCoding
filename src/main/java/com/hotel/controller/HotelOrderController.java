package com.hotel.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.entity.*;
import com.hotel.service.*;
import com.hotel.tools.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * (HotelOrder)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:24
 */
@Controller
@RequestMapping("order")
public class HotelOrderController {
    /**
     * 服务对象
     */
    @Resource
    private HotelOrderService hotelOrderService;

    @Resource
    private HotelOrderViewService hotelOrderViewService;

    @Resource
    private RoomRtViewService roomRtViewService;

    @Resource
    private UserMemTypeViewService userMemTypeViewService;

    @Resource
    private RoomService roomService;

    @Resource
    private RtypeService rtypeService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public HotelOrder selectOne(Integer id) {
        return this.hotelOrderService.queryById(id);
    }

    @ResponseBody
    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
    public Page OrderList(int page, int limit) throws JsonProcessingException {
        List<HotelOrderView> orders = hotelOrderViewService.queryAllByLimit(0+(page-1)*limit, limit);
        Page<HotelOrderView> orderPage = new Page<HotelOrderView>();
        orderPage.setCode(0);
        orderPage.setMsg("");
        orderPage.setCount(hotelOrderViewService.queryAllByLimit(0,10000).size());
        orderPage.setData(orders);
        return orderPage;
    }
    @RequestMapping("/gotoAdd")
    public ModelAndView gotoOrderAdd() {
        ModelAndView mv = new ModelAndView();
        RoomRtView roomRtView = new RoomRtView();
        roomRtView.setIsres(0);
        roomRtView.setRtypeid(1);
        mv.addObject("roomT",rtypeService.queryAllByLimit(0,10000));
        mv.addObject("room",roomRtViewService.queryAll(roomRtView));
        mv.addObject("mem",userMemTypeViewService.queryAllByLimit(0,10000));
        mv.setViewName("jsp/order/orderAdd");
        return mv;
    }
    @ResponseBody
    @RequestMapping(value = "/add", produces = "application/json;charset=utf-8")
    public int addOrderone(@RequestBody HotelOrderView hotelOrderView) {
        if(roomRtViewService.queryById(hotelOrderView.getRoomid()).getIsres()!= 0){
            return 0;
        }
        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setMemid(hotelOrderView.getMemid());
        hotelOrder.setRoomid(hotelOrderView.getRoomid());
        hotelOrder.setOrderstate(hotelOrderView.getOrderstate());
        hotelOrder.setDeposit(hotelOrderView.getDeposit());
        hotelOrder.setPrice(hotelOrderView.getOPrice());
        hotelOrder.setOrdertime(hotelOrderView.getOrdertime());
        hotelOrder.setPersonnum(hotelOrderView.getPersonnum());
        hotelOrder.setIntime(hotelOrderView.getIntime());
        hotelOrder.setOuttime(hotelOrderView.getOuttime());
        hotelOrder.setRemark(hotelOrderView.getRemark());

        Room room = new Room();
        room.setRoomid(hotelOrderView.getRoomid());
        room.setIsres(1);

        if(!roomService.update(room)) return 0;
        return hotelOrderService.insert(hotelOrder);
    }
    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteOrderOne(int orderid){
        return hotelOrderService.deleteById(orderid);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAll" ,produces =
            "application/json;charset=utf-8")
    public boolean deleteOrderAll(@RequestBody String orderids) throws JsonParseException, JsonMappingException, IOException {
//        System.out.println(depids);
        orderids = "["+orderids+"]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(orderids, javaType);
        return hotelOrderService.deleteAll(list.toArray(new Integer[list.size()]));
    }
    @RequestMapping("/gotoEdit")
    public ModelAndView editOrderone(int orderid) {

        ModelAndView mv = new ModelAndView();
        RoomRtView roomRtView = new RoomRtView();
        roomRtView.setIsres(0);
        roomRtView.setRtypeid(1);
        mv.addObject("roomT",rtypeService.queryAllByLimit(0,10000));
        mv.addObject("room",roomRtViewService.queryAll(roomRtView));
        mv.addObject("mem",userMemTypeViewService.queryAllByLimit(0,10000));
        mv.addObject("order",hotelOrderViewService.queryById(orderid));
        mv.setViewName("jsp/order/orderEdit");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public boolean updateOrderone(@RequestBody HotelOrderView hotelOrderView) {
        boolean flag = true; // 没换房-true 否则-false
        boolean isback = true; // 未退房-true 否则-false
        if(!Objects.equals(hotelOrderViewService.queryById(hotelOrderView.getOrderid()).getRoomid(),hotelOrderView.getRoomid())){//if换房
            flag = false;
            if(roomRtViewService.queryById(hotelOrderView.getRoomid()).getIsres()!= 0){//if换房后的房间已预定
                return false;
            }
        }

        if(Objects.equals(hotelOrderView.getOrderstate(),"已退房")) isback = false;

        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setOrderid(hotelOrderView.getOrderid());
        hotelOrder.setMemid(hotelOrderView.getMemid());
        hotelOrder.setRoomid(hotelOrderView.getRoomid());
        hotelOrder.setOrderstate(hotelOrderView.getOrderstate());
        hotelOrder.setDeposit(hotelOrderView.getDeposit());
        hotelOrder.setPrice(hotelOrderView.getOPrice());
        hotelOrder.setOrdertime(hotelOrderView.getOrdertime());
        hotelOrder.setPersonnum(hotelOrderView.getPersonnum());
        hotelOrder.setIntime(hotelOrderView.getIntime());
        hotelOrder.setOuttime(hotelOrderView.getOuttime());
        hotelOrder.setRemark(hotelOrderView.getRemark());

        if(!flag && isback) { // 如果换房了而且不是已退房
            Room room = new Room();
            room.setRoomid(hotelOrderView.getRoomid());
            room.setIsres(1);
            if(!roomService.update(room)) return false;
            room.setRoomid(hotelOrderViewService.queryById(hotelOrderView.getOrderid()).getRoomid());
            room.setIsres(0);
            if(!roomService.update(room)) return false;
        }else if(flag&&isback){ // 如果没换且不是已退房
            Room room = new Room();
            room.setRoomid(hotelOrderView.getRoomid());
            room.setIsres(1);
            if(!roomService.update(room)) return false;
        }else if(!flag&&!isback) { // 如果换房且是退房
            Room room = new Room();
            room.setRoomid(hotelOrderView.getRoomid());
            room.setIsres(0);
            if(!roomService.update(room)) return false;
            room.setRoomid(hotelOrderViewService.queryById(hotelOrderView.getOrderid()).getRoomid());
            room.setIsres(0);
            if(!roomService.update(room)) return false;
        }else { // 如果没换发且已经退房
            Room room = new Room();
            room.setRoomid(hotelOrderView.getRoomid());
            room.setIsres(0);
            if(!roomService.update(room)) return false;
        }

        return hotelOrderService.update(hotelOrder) > 0;
    }

    @ResponseBody
    @RequestMapping("/personnumCheck")
    public boolean roomNumCheck(int personnum,int roomid) {
        RoomRtView roomRtView = roomRtViewService.queryById(roomid);
        return (roomRtView.getLivenum() >= personnum);
    }

    @ResponseBody
    @RequestMapping(value = "getRTypeOfRoom",produces =
            "application/json;charset=utf-8")
    public List<RoomRtView> getRTypeOfRomm(int rtypeid){
        RoomRtView roomRtView = new RoomRtView();
        roomRtView.setRtypeid(rtypeid);
        roomRtView.setIsres(0);
        return  roomRtViewService.queryAll(roomRtView);
    }
    @ResponseBody
    @RequestMapping("getPrice")
    public Double getPrice(int memid,int rtypeid){
        Double discount = userMemTypeViewService.queryById(memid).getDiscount();
        Double price = rtypeService.queryById(rtypeid).getPrice();
        return discount*price;
    }
}
