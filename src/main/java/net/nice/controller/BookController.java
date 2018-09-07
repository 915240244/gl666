package net.nice.controller;

import com.github.pagehelper.PageInfo;
import net.nice.bean.Book;
import net.nice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    BookService bookService;



    /*首页的内容遍历*/
    @RequestMapping("index")
    public String index(@RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "6") Integer pageSize,Model model,
            HttpServletRequest request,HttpSession session){
        System.out.println(pageNum+"====page");
        PageInfo<Book> pageInfo=new PageInfo<Book>(bookService.allBook(pageNum,pageSize));
        model.addAttribute("bookList",pageInfo.getList());
        model.addAttribute("page",pageInfo);
        System.out.println("pageInfo = " + pageInfo);
        return "/index01.jsp";
    }

    @RequestMapping("/researchBook.do")

    public String searchCtms(Model model, String title) {

        model.addAttribute("researchBook", bookService.searchBook(title));

        return "/index01.jsp";
    }

    /*文学类书籍遍历*/
@RequestMapping("wenxue")
    public String wenxue(@RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "6") Integer pageSize,Model model,
                        HttpServletRequest request,HttpSession session){
        PageInfo<Book> pageInfo=new PageInfo<>(this.bookService.wxBook(pageNum,pageSize));
        model.addAttribute("wxbooks",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "/wenxue.jsp";
    }

    /*小说类书籍遍历*/
    @RequestMapping("shenghuo")
    public String shenghuo(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "6") Integer pageSize,Model model){
        PageInfo<Book> pageInfo=new PageInfo<>(this.bookService.shBook(pageNum,pageSize));
        model.addAttribute("shbooks",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "/shenghuo.jsp";
    }

/*科技类书籍遍历*/
    @RequestMapping("keji")
    public String keji(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "6") Integer pageSize,Model model,HttpSession session){
        PageInfo<Book> pageInfo=new PageInfo<>(this.bookService.kjBook(pageNum,pageSize));
        List<Book> list=bookService.kjBook(pageNum,pageSize);
        for (Book book:list) {
            session.setAttribute("bookId",book.getBook_ID());
            System.out.println(session.getAttribute("bookId"));

        }
        model.addAttribute("kjbooks",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "/keji.jsp";
    }

    /*历史类书籍遍历*/
    @RequestMapping("lishi")
    public String lishi(@RequestParam(defaultValue = "1") Integer pageNum,
                        @RequestParam(defaultValue = "6") Integer pageSize,Model model){
    PageInfo<Book> pageInfo=new PageInfo<>(this.bookService.lsBook(pageNum,pageSize));
    model.addAttribute("lsbooks",pageInfo.getList());
    model.addAttribute("pageInfo",pageInfo);
    return "/lishi.jsp";
    }

    @RequestMapping("test")
    public  String  text(){
        System.out.println(" 成功范文到了这里 " );
        Book book = new Book();

        return "c测试成功";
    }


}
