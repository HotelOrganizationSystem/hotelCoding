package com.hotel.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.entity.*;
import com.hotel.service.RtypeService;
import com.hotel.tools.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * 客房类型表(Rtype)表控制层
 *
 * @author makejava
 * @since 2021-07-08 16:43:28
 */
@Controller
@RequestMapping("rtype")
public class RtypeController {
    /**
     * 服务对象
     */
    @Resource
    private RtypeService rtypeService;

    @RequestMapping(value = "/list", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String empList(int page, int limit) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Rtype> rtypes = rtypeService.queryAllByLimit(0 + (page - 1) * limit, limit);
        Page<Rtype> rtypePage = new Page<Rtype>();
        rtypePage.setCode(0);
        rtypePage.setMsg("");
        rtypePage.setCount(rtypeService.queryAllByLimit(0, 10000).size());
        rtypePage.setData(rtypes);
        String s = mapper.writeValueAsString(rtypePage);
        return s;
    }

    @RequestMapping("/gotoAdd")
    public ModelAndView AddEmpone() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("jsp/rtype/rtypeAdd");
        return mv;
    }

    @ResponseBody
    @PostMapping("/add")
    public int addEtypeone(Rtype rtype,HttpServletRequest request) throws IOException {

        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath;
        localPath = request.getRealPath("upload");
        System.out.println(localPath);
        //定义 文件名
        String filename = null;
        if (!Objects.equals(rtype.getFile(),null)) {
            //生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = rtype.getFile().getContentType();
            //获得文件后缀名
            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
            //设置允许上传文件类型
            String suffixList = "jpg,png,ico,bmp,jpeg";
            if (!suffixList.contains(suffixName))return -1;
            //得到 文件名
            filename = uuid + "." + suffixName;
            System.out.println(filename);
            //文件保存路径

            rtype.getFile().transferTo(new File(localPath + "/" + filename));
            sqlPath = "/upload/" + filename;
            System.out.println(sqlPath);
            //把图片的相对路径保存至数据库
            rtype.setDefimg(sqlPath);
            return rtypeService.insert(rtype);
        }
        //图片未找到
       return -1;

    }

    @ResponseBody
    @RequestMapping("/delete")
    public boolean deleteDepOne(int rtypeid) {
        return rtypeService.deleteById(rtypeid);
    }

    @ResponseBody
    @RequestMapping(value = "/deleteAll", produces =
            "application/json;charset=utf-8")
    public boolean deleteDepAll(@RequestBody String rtypeids) throws JsonParseException, JsonMappingException, IOException {
//        System.out.println(depids);
        rtypeids = "[" + rtypeids + "]";
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, Integer.class);
        List<Integer> list = objectMapper.readValue(rtypeids, javaType);
        return rtypeService.deleteAll(list.toArray(new Integer[list.size()]));
    }

    @RequestMapping("/gotoEdit")
    public ModelAndView editDepone(int rtypeid) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("rtype", rtypeService.queryById(rtypeid));
        mv.setViewName("jsp/rtype/rtypeEdit");
        return mv;
    }

    @ResponseBody
    @RequestMapping("/edit")
    public boolean updateDepone( Rtype rtype ,HttpServletRequest request) throws IOException {
        System.out.println(rtype);
        String sqlPath = null;
        //定义文件保存的本地路径
        String localPath;
        localPath = request.getRealPath("upload");
        System.out.println(localPath);
        //定义 文件名
        String filename = null;
        if (!Objects.equals(rtype.getFile(),null)) {

            //获得文件类型（可以判断如果不是图片，禁止上传）
            String contentType = rtype.getFile().getContentType();
            //获得文件后缀名
            String suffixName = contentType.substring(contentType.indexOf("/") + 1);
            //设置允许上传文件类型
            String suffixList = "jpg,png,ico,bmp,jpeg";
            if (suffixList.contains(suffixName)){
                //生成uuid作为文件名称
                String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                //得到 文件名
                filename = uuid + "." + suffixName;
                //文件保存路径
                rtype.getFile().transferTo(new File(localPath + "/" + filename));
                sqlPath = "/upload/" + filename;
                //把图片的相对路径保存至数据库
                rtype.setDefimg(sqlPath);
            }
        }
        return rtypeService.update(rtype);
    }


}
