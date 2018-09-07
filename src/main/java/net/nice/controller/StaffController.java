package net.nice.controller;

import net.nice.bean.Staff;
import net.nice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class StaffController {
    @Autowired
    StaffService staffService;

    //管理员登录
    @RequestMapping("adminLoin.do")
    @ResponseBody
    public Object AdminLogin(@RequestParam("user") String staff_Number,
                             @RequestParam("pass") String staff_Password,
                             HttpSession session){
        Staff staff = new Staff(staff_Number,staff_Password);

        Staff af = staffService.adminLogin(staff);
        if (af!=null){

            session.setAttribute("adminUser",af);
            return "yse";
        }
        return "no";
    }
    @RequestMapping("bookTz.do")
    public Object bookTz(){
        return "WEB-INF/admin/person/book_zt.jsp";
    }


    //以下是菜单点击跳转规定的界面
    //单击   修改界面
    @RequestMapping("upBooksJsp.do")
    public String upBookJsp(){
        return "WEB-INF/admin/person/upBooks.jsp";
    }
    //单击 添加界面
    @RequestMapping("addBookJsp.do")
    public String addBookJsp(){
        return "WEB-INF/admin/person/addBook.jsp";
    }
    //单击 书籍状态界面
    @RequestMapping("book_ztJsp.do")
    public String deleteBookJsp(){
        return "WEB-INF/admin/person/book_zt.jsp";
    }
    //单击 用户申请表
    @RequestMapping("borrowedJsp.do")
    public String borrowedJsp(){
        return "WEB-INF/admin/person/borrowed.jsp";
    }
    //单击 读者消息
    @RequestMapping("readerJsp.do")
    public String readerJsp(){
        return "WEB-INF/admin/person/reader.jsp";
    }
    @RequestMapping("returnJsp.do")

    //借阅记录
    public String returnJsp(){
        return  "WEB-INF/admin/person/returnRecord.jsp";
    }
}
