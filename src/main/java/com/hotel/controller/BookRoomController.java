package com.hotel.controller;

import com.hotel.entity.*;
import com.hotel.service.BookRoomService;
import com.hotel.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/book")
public class BookRoomController {
   @Resource
    private BookRoomService bookRoomService;
   @Resource
   private MemberTypeService memberTypeService;

    @RequestMapping(value = "/book_room")
    public ModelAndView testLayUi(@RequestParam(value = "rtypeId", required = false) Integer rtypeId,
                                  @RequestParam(value = "isFoot", required = false) Integer isFoot,
                                  @RequestParam(value = "isNet", required = false) Integer isNet,
                                  @RequestParam(value = "price", required = false, defaultValue = "0-2147483647") String price,
                                  HttpSession session) {
        ModelAndView mv = new ModelAndView("jsp/book_room/book_room");

        Map<String, Object> maps = new HashMap<>();

        maps.put("isFoot", isFoot);
        maps.put("isNet", isNet);
        maps.put("rtypeId", rtypeId);
        maps.put("p1", price.split("-")[0]);
        maps.put("p2", price.split("-")[1]);

        List<Rtype> roomTypes = bookRoomService.getTypes(maps);

        mv.addObject("roomTypes", roomTypes);
        mv.addObject("allTypes", bookRoomService.getAllRType());
        mv.addObject("member", session.getAttribute("member"));

        return mv;
    }

    @ResponseBody
    @RequestMapping(value = "/book_choose")
    public List<Rtype> test2(@RequestParam(value = "rtypeId", required = false) Integer rtypeId,
                             @RequestParam(value = "isFoot", required = false) Integer isFoot,
                             @RequestParam(value = "isNet", required = false) Integer isNet,
                             @RequestParam(value = "price", required = false, defaultValue = "0-2147483647") String price) {
        Map<String, Object> maps = new HashMap<>();

        maps.put("isFoot", isFoot);
        maps.put("isNet", isNet);
        maps.put("rtypeId", rtypeId);
        maps.put("p1", price.split("-")[0]);
        maps.put("p2", price.split("-")[1]);

        return bookRoomService.getTypes(maps);
    }

    @RequestMapping("/payment")
    @ResponseBody
    public Map<String,Object> payment(HttpSession session,
                          @RequestParam(value = "price", required = true) Double price) {
        Member member = (Member) session.getAttribute("member");

        Map<String,Object> maps = new HashMap<>();
        Users user = (Users) session.getAttribute("user");
        maps.put("user", user);
        maps.put("member", member);
        MemberType memberType = new MemberType();
        memberType.setMemTypeId(member.getMemTypeId());
        MemberType memberTypes = memberTypeService.queryAll(memberType).get(0);
        maps.put("memT",memberTypes);
        maps.put("price",  memberTypes.getDiscount()* price);
        return maps;
    }

    @RequestMapping("/order")
    @ResponseBody
    public int insert_order(@RequestParam("rtypeid") Integer rtypeid,
                            @RequestParam("personnum") Integer personnum,
                            @RequestParam("price") Double price,
                            HttpSession session) {
        Member member = (Member) session.getAttribute("member");

        HotelOrder hotelOrder = new HotelOrder();
        hotelOrder.setPersonnum(personnum);
        hotelOrder.setPrice(price);
        hotelOrder.setDeposit(0);
        hotelOrder.setOrdertime(new Timestamp(new Date().getTime()));

        hotelOrder.setMemid(member.getMemid());

        int i = bookRoomService.insert_order(hotelOrder, rtypeid);

        return i;
    }
}
