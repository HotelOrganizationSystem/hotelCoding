package com.hotel.controller;

import com.hotel.entity.Member;
import com.hotel.entity.Users;
import com.hotel.service.MemberService;
import com.hotel.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户表(Users)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:29
 */
@Controller
@RequestMapping("users")

public class UsersController {
    /**
     * 服务对象
     */
    @Resource
    private UsersService usersService;

    @Resource
    private MemberService memberService;
    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        Users users = new Users();
        users.setAccount(username);
        users.setPassword(password);
        List<Users> usersList = usersService.queryAll(users);
        if (usersList.size() != 0) {
            HttpSession session = request.getSession();
            session.setAttribute("user",usersList.get(0));
            Member member = new Member();
            member.setUsersid(usersList.get(0).getUsersid());
            session.setAttribute("member", memberService.queryAll(member).get(0));
            return "index";
        }
        return "error";
    }

    @RequestMapping("updatePwd")
    public String updatePwd(String password,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        user.setPassword(password);
        System.out.println(user);
        Users update = usersService.update(user);
        System.out.println(update);
        session.setAttribute("user",update);
        return "index";
    }

}
