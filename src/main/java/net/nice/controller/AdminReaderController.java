package net.nice.controller;

import net.nice.bean.AdminReader_info;
import net.nice.service.AdminReaderService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminReaderController {
    @Autowired
    AdminReaderService AdminReaderService;
    //显示全部读者数据-book_zt.jsp
    @RequestMapping(value = "AdminReader.do" )
    @ResponseBody
    public Object Readerlike(){
        List<AdminReader_info> readerlist = AdminReaderService.getAllReader();
        JSONArray jsonArray = JSONArray.fromObject(readerlist);
        return jsonArray.toString();
    }

//读者姓名查询
    @RequestMapping("AdminReaderName.do")
    @ResponseBody
    public  String  readerName(@RequestParam("name")String  name){

        List<AdminReader_info> readerList = AdminReaderService.readerList(name);
        if (readerList==null) return "";

        JSONArray jsonArray = JSONArray.fromObject(readerList);
        System.out.println("jsonArray = " + jsonArray);
        return jsonArray.toString();
    }
    //读者身份证查询
    @RequestMapping("AdminReaderID.do")
    @ResponseBody
    public  String  readerId(@RequestParam("reader") String readerID ){

        AdminReader_info readerId = AdminReaderService.readerId(readerID);
        if (readerId==null) return "";
        JSONArray jsonArray = JSONArray.fromObject(readerId);
        return jsonArray.toString();
    }
}
