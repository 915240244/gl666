package net.nice.controller;

import com.github.pagehelper.PageInfo;
import net.nice.bean.Book;
import net.nice.bean.Borrowed;
import net.nice.service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BorrowedController {

    @Autowired
    BorrowedService borrowedService;

 /*   @RequestMapping("/jilu.do")
    public String addborr(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "1") Integer pageSize, Model model,
                          HttpSession session){
        PageInfo<Borrowed> pageInfo = new PageInfo<>(this.borrowedService.addBorrowed(pageNum, pageSize, (Reader) session.getAttribute("reader")));
        model.addAttribute("borrowed",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        System.out.println("pageInfo = " + pageInfo);
        System.out.println("pageInfo = " + pageInfo.getList());
        return "/inex01.jsp";
    }*/

    @RequestMapping("/find.do")
    public String keji(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "1") Integer pageSize, Model model,
                       HttpSession session) {
        PageInfo<Borrowed> pageInfo = new PageInfo<>(borrowedService.findBorrowed(pageNum, pageSize, (String) session.getAttribute("Id")));
        model.addAttribute("re", pageInfo.getList());
        model.addAttribute("pageInfo", pageInfo);
        System.out.println("pageInfo = " + pageInfo.getList());
        System.out.println("model = " + model);
        return "/test.jsp";
    }


    @RequestMapping("/findBook.do")
    @ResponseBody
    public String findOneParking(@RequestParam("book_ID") int book_ID,Model model,HttpSession session) {
        System.out.println(book_ID);
        Book book = borrowedService.BorrowBooke(book_ID);
        System.out.println(book.getStocks());
        if (book.getStocks() == 0) {
            return "fail";
            /*      System.out.println("没有书")*/

        } else {
            book.setStocks(0);
            boolean b=borrowedService.undateStock(book);
            if (b){
                /*session.removeAttribute("reader");*/

                return "success";
            }else return "fails";


        }
    }
}
