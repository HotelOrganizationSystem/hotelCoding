package com.hotel.controller;

import javax.annotation.Resource;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.entity.Dep;
import com.hotel.tools.Page;
import com.hotel.service.DepService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("dep")
public class DepController {
    /**
     * 服务对象
     */
    @Resource
    private DepService depService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @RequestMapping(value = "/list", produces =
            "application/json;charset=utf-8")
    @ResponseBody
    public String depList(int page,int limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Dep> emps = depService.queryAllByLimit(0+(page-1)*limit, limit);
        Page<Dep> depPage = new Page<Dep>();
        depPage.setCode(0);
        depPage.setMsg("");
        depPage.setCount(emps.size());
        depPage.setData(emps);
        String s = mapper.writeValueAsString(depPage);
        return s;
    }
    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteDepOne(int depid){
        return depService.deleteById(depid);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAll" ,produces =
            "application/json;charset=utf-8")
    public boolean deleteDepAll(@RequestBody String depids) throws JsonParseException, JsonMappingException, IOException{
//        System.out.println(depids);
        depids = "["+depids+"]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(depids, javaType);
        return depService.deleteByIds(list.toArray(new Integer[list.size()]));
    }

    @ResponseBody
    @RequestMapping("/add")
    public int addDepone(String depName, String remark) {
        Dep dep = new Dep();
        dep.setDepname(depName);
        dep.setRemark(remark);
        return depService.insert(dep);
    }

    @RequestMapping("/gotoEdit")
    public ModelAndView editDepone(int depid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("dep",depService.queryById(depid));
        mv.setViewName("jsp/dep/depEdit");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public boolean updateDepone(int depid, String depName, String remark) {
        Dep dep = new Dep();
        dep.setDepid(depid);
        dep.setDepname(depName);
        dep.setRemark(remark);
        return depService.update(dep);
    }
}
