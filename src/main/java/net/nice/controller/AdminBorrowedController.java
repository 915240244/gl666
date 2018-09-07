package net.nice.controller;


import net.nice.bean.AdminBborrowed_record;
import net.nice.bean.AdminReturn_record;
import net.nice.bean.AdminStaff;
import net.nice.service.AdminRetrunService;
import net.nice.service.AdminBorrowedService;
import net.nice.utils.Date;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class AdminBorrowedController {
            @Autowired
            AdminBorrowedService AdminBorrowedService;
            @Autowired
            private AdminRetrunService adminRetrunService;


            //为归还用户查询
            @RequestMapping("AdminSelectBack.do")
            @ResponseBody
            public  Object  selectBack(@RequestParam("back") int back){

                List<AdminBborrowed_record> record = AdminBorrowedService.record(back);

                JSONArray jsonArray = JSONArray.fromObject(record);
                System.out.println(jsonArray.toString());
                return jsonArray.toString();
            }

            //借阅用户姓名的查询
        @RequestMapping("AdminNameSelect.do")
        @ResponseBody
            public Object nameSelect(@RequestParam("name") String name){
            List<AdminBborrowed_record> nameList = AdminBorrowedService.nameSelect(name);
            JSONArray jsonArray = JSONArray.fromObject(nameList);
            return jsonArray.toString();

            }


            //修改归还状态
        @RequestMapping("AdminUpBack.do")
        @ResponseBody
        public String upback(@RequestParam("borId") String borId,
                             @RequestParam("back") int back){
            System.out.println("borId = " + borId+back);
                AdminBborrowed_record br = new AdminBborrowed_record(borId,back);
            Boolean upback = AdminBorrowedService.upback(br);
            if (upback)return "yes";
            return "no";
        }


        //书名查询
    @RequestMapping("AdminTitleSelect.do")
    @ResponseBody
    public  String  titleSelect(@RequestParam("name") String title){
        List<AdminBborrowed_record> bookList = AdminBorrowedService.titleSelect(title);
        JSONArray jsonArray = JSONArray.fromObject(bookList);
        return jsonArray.toString();
    }
    //申请人身份证查询
    @RequestMapping("AdminReaderId.do")
    @ResponseBody
    public  String  readerId(@RequestParam("AdminReaderService") String reader){
        List<AdminBborrowed_record> AdminBborrowed_records = AdminBorrowedService.readerId(reader);
        JSONArray jsonArray = JSONArray.fromObject(AdminBborrowed_records);
        return jsonArray.toString();
    }


    //当操作归还时产生一条借书记录数据
    @RequestMapping("AdminReturnBook.do")
    @ResponseBody
    public String returnBook(@RequestParam("borId") String borId,
                             @RequestParam("title") String title,
                             @RequestParam("name") String  name,
                             HttpSession session){
                //获取当前登录的管理员
        AdminStaff adminUser = (AdminStaff) session.getAttribute("adminUser");
        //获取当前管理员的编号和名字
        String staff_number = adminUser.getStaff_Number();
        String staff_name = adminUser.getStaff_Name();

        AdminReturn_record record = new AdminReturn_record(borId,title,name,staff_number,staff_name,"2017-10-23 13:22:32");

        Boolean aBoolean = AdminBorrowedService.returnBook(record);
        System.out.println("aBoolean = " + aBoolean);
        return "yes";
    }

    @RequestMapping("AdminHuanshu.do")
    @ResponseBody
    public String BookReturn(@RequestParam("borrowed_ID") String borrowed_ID,
                             @RequestParam("title") String title,
                             @RequestParam("reader_Name") String  reader_Name,
                             @RequestParam("staff_Number") String staff_Number,
                             @RequestParam("staff_Name") String staff_Name){
       int borrowedResult= AdminBorrowedService.updateBack(borrowed_ID);

       LocalDateTime now = LocalDateTime.now();

       String formatDate= Date.date(now);

       AdminReturn_record AdminReturn_record =new AdminReturn_record(borrowed_ID,title,reader_Name,staff_Number,staff_Name,formatDate );

       if(borrowedResult!=0){
           int insertrecord= adminRetrunService.insertInfo(AdminReturn_record);
           if(insertrecord==0){
               return "no";
           }
       }
       return "yes";
    }

}
