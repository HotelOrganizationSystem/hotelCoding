package com.hotel.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.entity.MemberType;
import com.hotel.tools.Page;
import com.hotel.service.MemberTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * 会员类型表(MemberType)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:26
 */
@Controller
@RequestMapping("memT")
public class MemberTypeController {
    /**
     * 服务对象
     */
    @Resource
    private MemberTypeService memberTypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MemberType selectOne(Integer id) {
        return this.memberTypeService.queryById(id);
    }

    @RequestMapping(value = "list", produces =
            "application/json;charset=utf-8")
    @ResponseBody
    public String memTypeList(int page,int limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<MemberType> memberTypes = memberTypeService.queryAllByLimit(0+(page-1)*limit, limit);
        Page<MemberType> memberTypePagePage = new Page<MemberType>();
        memberTypePagePage.setCode(0);
        memberTypePagePage.setMsg("");
        memberTypePagePage.setCount(memberTypeService.queryAllByLimit(0,100000).size());
        memberTypePagePage.setData(memberTypes);
        String s = mapper.writeValueAsString(memberTypePagePage);
        return s;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteMemTOne(int memTypeId){
        return memberTypeService.deleteById(memTypeId);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAll" ,produces =
            "application/json;charset=utf-8")
    public boolean deleteMemTAll(@RequestBody String memTypeIds) throws  IOException {

        memTypeIds = "["+ memTypeIds +"]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(memTypeIds, javaType);
        return memberTypeService.deleteAll(list.toArray(new Integer[list.size()]));
    }

   @RequestMapping("gotoAdd")
   public String gotoAdd(){
        return "jsp/memT/memTAdd";
   }

    @ResponseBody
    @RequestMapping("add")
    public int addMemT(@RequestBody MemberType memberType){

        return memberTypeService.insert(memberType);
    }

    @RequestMapping("gotoEdit")
    public ModelAndView gotoEdit(int memTypeId){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("memT",memberTypeService.queryById(memTypeId));
        modelAndView.setViewName("jsp/memT/memTEdit");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("edit")
    public boolean editMemT(@RequestBody MemberType memberType){
        return memberTypeService.update(memberType);
    }
}
