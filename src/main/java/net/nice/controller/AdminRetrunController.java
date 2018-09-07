package net.nice.controller;


import net.nice.bean.AdminReturn_record;
import net.nice.service.AdminRetrunService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminRetrunController {
    @Autowired
    AdminRetrunService serivce;
    @RequestMapping("AdminBookName.do")
    @ResponseBody
    public String bookname(@RequestParam("reader")String reader){
        System.out.println("成功访问啦");
        List<AdminReturn_record> booname = serivce.booname(reader);

        JSONArray jsonArray = JSONArray.fromObject(booname);
        return jsonArray.toString();
    }
        @RequestMapping("AdminRecordList.do")
        @ResponseBody
    public String reocrdlist(){
            List<AdminReturn_record> recordList = serivce.recordList();
            JSONArray jsonArray = JSONArray.fromObject(recordList);
            return jsonArray.toString();
        }
}
