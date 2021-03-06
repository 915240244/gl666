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

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
            /*#{book_ID},#{reader_ID},#{title},#{borrowed_Time}*/
            Borrowed borrowed=new Borrowed();
            borrowed.setBook_ID(book_ID);
            borrowed.setReader_ID((String) session.getAttribute("Id"));
            borrowed.setTitle(book.getTitle());
            Date date=new Date();
            Calendar calendar=Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH,+60);
            date=calendar.getTime();
            String sdf = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
            borrowed.setBorrowed_Time(sdf);
            this.borrowedService.bookRecord(borrowed);
            book.setStocks(0);
            boolean b=borrowedService.undateStock(book);
            if (b){
                /*session.removeAttribute("reader");*/

                return "success";
            }else return "fails";


        }
    }

    @RequestMapping("huanshu")
    @ResponseBody
    public String huanshu(@RequestParam("book_ID") int book_ID,HttpSession session){
        System.out.println("book_ID = " + book_ID);
        if (Integer.toString(book_ID)==null){
            return "fail";
        }else {
            this.borrowedService.bookremove(book_ID);
            Book book = borrowedService.BorrowBooke(book_ID);
            book.setStocks(1);
            boolean undateStock = borrowedService.undateStock(book);
            if (undateStock){
                return "success";
            }else {
                return "fails";
            }
        }



    }
}
