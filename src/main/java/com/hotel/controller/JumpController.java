package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jump")
public class JumpController {

    @RequestMapping("/pwd_update")
    public String pwd(){
        return "pwd_update";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/exit")
    public String exit(){
        return "exit";
    }

    @RequestMapping("/depTable")
    public String dep(){ return "jsp/dep/depList";}

    @RequestMapping("/depAdd")
    public String depAdd() {return "jsp/dep/depAdd";}

    @RequestMapping("/memT")
    public String memT(){
        return "jsp/memT/memTList";
    }

    @RequestMapping("/mem")
    public  String mem(){
        return "jsp/mem/memList";
    }
    @RequestMapping("/empList")
    public String empList() {return "jsp/emp/empList";}

    @RequestMapping("/rtypeList")
    public String rtypeList() {return "jsp/rtype/rtypeList";}

    @RequestMapping("/roomList")
    public String roomList() {return "jsp/room/roomList";}

    @RequestMapping("/orderList")
    public String orderList() {return "jsp/order/orderList";}
}
