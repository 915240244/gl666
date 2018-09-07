package net.nice.controller;

import net.nice.bean.AdminStaff;
import net.nice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class AdminController {
    @Autowired
    AdminService adminstaff;

    //管理员登录
    @RequestMapping("AdminLoin.do")
    @ResponseBody
    public  Object  AdminLogin(@RequestParam("user") String user,
                               @RequestParam("pass") String pass,
                               HttpSession session
                               ){

         AdminStaff admin = new AdminStaff(user,pass);

        AdminStaff af = adminstaff.AdminLogin(admin);
        if (af!=null){
                session.setAttribute("adminUser",af);
                return "yse";
            }
    return "no";
    }
    @RequestMapping("AdminBookTz.do")
    public  Object bookTz(){
        return "WEB-INF/admin/person/book_zt.jsp";
    }

    //以下是菜单点击跳转规定的界面
    //单击   修改界面
    @RequestMapping("AdminUpBooksJsp.do")
    public String upBookJsp(){
        return "WEB-INF/admin/person/upBooks.jsp";
    }
    //单击 添加界面
    @RequestMapping("AdminAddBookJsp.do")
    public String addBookJsp(){
        return "WEB-INF/admin/person/addBook.jsp";
    }
    //单击 书籍状态界面
 @RequestMapping("AdminBook_ztJsp.do")
    public String deleteBookJsp(){
        return "WEB-INF/admin/person/book_zt.jsp";
    }
    //单击 用户申请表
    @RequestMapping("AdminBorrowedJsp.do")
    public String borrowedJsp(){
        return "WEB-INF/admin/person/borrowed.jsp";
    }
    //单击 读者消息
    @RequestMapping("AdminReaderJsp.do")
    public String readerJsp(){
        return "WEB-INF/admin/person/reader.jsp";
    }
    @RequestMapping("AdminReturnJsp.do")

    //借阅记录
    public String returnJsp(){
        return  "WEB-INF/admin/person/returnRecord.jsp";
    }
}


