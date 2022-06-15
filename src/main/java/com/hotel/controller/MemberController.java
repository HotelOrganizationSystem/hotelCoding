package com.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
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

/**
 * 会员表(Member)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:25
 */
@Controller
@RequestMapping("mem")
public class MemberController {
    /**
     * 服务对象
     */
    @Resource
    private MemberService memberService;
    @Resource
    private UserMemTypeViewService userMemTypeViewService;
    @Resource
    private UsersService usersService;
    @Resource
    private MemberTypeService memberTypeService;
    @Resource
    private RoleService roleService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Member selectOne(Integer id) {
        return this.memberService.queryById(id);
    }

    @RequestMapping(value = "/list", produces =
            "application/json;charset=utf-8")
    @ResponseBody
    public Page<UserMemTypeView> empList(int page, int limit) throws JsonProcessingException {
        List<UserMemTypeView> emps = userMemTypeViewService.queryAllByLimit(0 + (page - 1) * limit, limit);
        Page<UserMemTypeView> empPage = new Page<UserMemTypeView>();
        empPage.setCode(0);
        empPage.setMsg("");
        empPage.setCount(userMemTypeViewService.queryAllByLimit(0, 10000).size());
        empPage.setData(emps);
        return empPage;
    }

    @RequestMapping("/gotoAdd")
    public ModelAndView AddEmpone() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("memT", memberTypeService.queryAllByLimit(0, 30));
        mv.addObject("role", roleService.queryAllByLimit(0, 30));
        mv.setViewName("jsp/mem/memAdd");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/add")
    public int addMemOne(@RequestBody UserMemTypeView userMemTypeView) {
        System.out.println(userMemTypeView);
        Users users = new Users();
        users.setAccount(userMemTypeView.getAccount());
        if (usersService.queryAll(users).size()!=0)return 0;
        users.setPassword(userMemTypeView.getPassword());
        users.setRoleid(userMemTypeView.getRoleid());
        // 插入数据
        Users usersInsert = usersService.insert(users);
        if (usersInsert == null) return 0;
        Member member = new Member();
        member.setUsersid(usersInsert.getUsersid());
        member.setMemTypeId(userMemTypeView.getMemTypeId());
        member.setMemname(userMemTypeView.getMemname());
        member.setPhone(userMemTypeView.getPhone());
        member.setMemsex(userMemTypeView.getMemsex());
        member.setIdcard(userMemTypeView.getIdcard());
        member.setEmail(userMemTypeView.getEmail());
        member.setMemint(userMemTypeView.getMemint());
        member.setRegisdate(userMemTypeView.getRegisdate());
        member.setUserstate(userMemTypeView.getUserstate());
        member.setRemark(userMemTypeView.getRemark());
        if (memberService.insert(member) == null) return 0;
        return 1;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteDepOne(int usersid) {
        return usersService.deleteById(usersid);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAll", produces =
            "application/json;charset=utf-8")
    public boolean deleteDepAll(@RequestBody String usersids) throws  IOException {
        usersids = "[" + usersids + "]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(usersids, javaType);
        return usersService.deleteAll(list.toArray(new Integer[list.size()]));
    }

    @RequestMapping("/gotoEdit")
    public ModelAndView editDepone(int memid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("memT", memberTypeService.queryAllByLimit(0, 30));
        mv.addObject("role", roleService.queryAllByLimit(0, 30));
        UserMemTypeView userMemTypeView = userMemTypeViewService.queryById(memid);
        mv.addObject("mem", userMemTypeView);
        mv.setViewName("jsp/mem/memEdit");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public boolean updateDepone(@RequestBody UserMemTypeView userMemTypeView) {

        Users users = new Users();
        users.setUsersid(userMemTypeView.getUsersid());
        users.setRoleid(userMemTypeView.getRoleid());
        users.setPassword(userMemTypeView.getPassword());
        users.setAccount(userMemTypeView.getAccount());
        if (usersService.update(users) == null) return false;

        Member member = new Member();
        member.setMemid(userMemTypeView.getMemid());
        member.setUsersid(userMemTypeView.getUsersid());
        member.setMemTypeId(userMemTypeView.getMemTypeId());
        member.setMemname(userMemTypeView.getMemname());
        member.setPhone(userMemTypeView.getPhone());
        member.setMemsex(userMemTypeView.getMemsex());
        member.setIdcard(userMemTypeView.getIdcard());
        member.setEmail(userMemTypeView.getEmail());
        member.setMemint(userMemTypeView.getMemint());
        member.setRegisdate(userMemTypeView.getRegisdate());
        member.setUserstate(userMemTypeView.getUserstate());
        member.setRemark(userMemTypeView.getRemark());
        if (memberService.update(member) == null) return false;
        return true;
    }
}
