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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 员工表(Emp)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:23
 */
@Controller
@RequestMapping("emp")
public class EmpController {
    /**
     * 服务对象
     */
    @Resource
    private EmpService empService;

    @Resource
    private DepService depService;

    @Resource
    private UsersService usersService;
    @Resource
    private RoleService roleService;

    @Resource
    private UsersDepEmpViewService usersDepEmpViewService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */

    @ResponseBody
    public String selectOne(Integer id) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Emp> emps = this.empService.queryAllByLimit(0, 100);
        String s = mapper.writeValueAsString(emps);
        return s;
    }

    @RequestMapping(value = "/list", produces =
            "application/json;charset=utf-8")
    @ResponseBody
    public String empList(int page, int limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<UsersDepEmpView> emps = usersDepEmpViewService.queryAllByLimit(0 + (page - 1) * limit, limit);
        Page<UsersDepEmpView> empPage = new Page<UsersDepEmpView>();
        empPage.setCode(0);
        empPage.setMsg("");
        empPage.setCount(usersDepEmpViewService.queryAllByLimit(0, 10000).size());
        empPage.setData(emps);
        String s = mapper.writeValueAsString(empPage);
        return s;
    }

    @RequestMapping("/gotoAdd")
    public ModelAndView AddEmpone() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("dep", depService.queryAllByLimit(0, 30));
        mv.addObject("role", roleService.queryAllByLimit(0, 30));
        mv.setViewName("jsp/emp/empAdd");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/add")
    public int addEmpone(String account, String password, String empName, int depId, int roleId, String sex, int age, String phone, int wage, int pay, String email, String eTime, String remark) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(eTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Users users = new Users();
        users.setAccount(account);
        // 插入数据
        if (usersService.queryAll(users) !=null) return 0;
        users.setPassword(password);
        users.setRoleid(roleId);
        usersService.insert(users);
        users = usersService.queryAll(users).get(0);
//        dep.setDepname(depName);
//        dep.setRemark(remark);
        Emp emp = new Emp();
        emp.setEmpage(age);
        emp.setEmpemail(email);
        emp.setEmpname(empName);
        emp.setEmppay(pay);
        emp.setEmpsex(sex);
        emp.setEtime(date);
        emp.setRemark(remark);
        emp.setEmpphone(phone);
        emp.setEmpwage(wage);
        emp.setDepid(depId);
        emp.setUsersid(users.getUsersid());
        if (empService.insert(emp) == null) return 0;
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
    public boolean deleteDepAll(@RequestBody String usersids) throws JsonParseException, JsonMappingException, IOException {
//        System.out.println(depids);
        usersids = "[" + usersids + "]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(usersids, javaType);
        return usersService.deleteAll(list.toArray(new Integer[list.size()]));
    }

    @RequestMapping("/gotoEdit")
    public ModelAndView editDepone(int empid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("dep", depService.queryAllByLimit(0, 30));
        mv.addObject("role", roleService.queryAllByLimit(0, 30));
        UsersDepEmpView usersDepEmpView = usersDepEmpViewService.queryById(empid);
        mv.addObject("emp", usersDepEmpView);
        mv.setViewName("jsp/emp/empEdit");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public boolean updateDepone(@RequestBody UsersDepEmpView usersDepEmpView) {
        Users users = new Users();
        users.setAccount(usersDepEmpView.getAccount());
        // 插入数据
        if (usersService.queryAll(users).size() != 0) return false;
        users.setPassword(usersDepEmpView.getPassword());
        users.setRoleid(usersDepEmpView.getRoleid());
        usersService.insert(users);
        users = usersService.queryAll(users).get(0);

        Emp emp = new Emp();
        emp.setEmpid(usersDepEmpView.getEmpid());
        emp.setDepid(usersDepEmpView.getDepid());
        emp.setUsersid(usersDepEmpView.getUsersid());
        emp.setEmpname(usersDepEmpView.getEmpname());
        emp.setEmpsex(usersDepEmpView.getEmpsex());
        emp.setEmpage(usersDepEmpView.getEmpage());
        emp.setEmpphone(usersDepEmpView.getEmpphone());
        emp.setEmpwage(usersDepEmpView.getEmpwage());
        emp.setEmpemail(usersDepEmpView.getEmpemail());
        emp.setEmppay(usersDepEmpView.getEmppay());
        emp.setEtime(usersDepEmpView.getEtime());
        emp.setRemark(usersDepEmpView.getRemark());

        if (empService.update(emp) == null) return false;
        return true;
    }
}
