package net.nice.controller;

import net.nice.bean.AdminBook;
import net.nice.service.AdminBookSenvice;

import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminBookController {
    @Autowired
    private AdminBookSenvice adminBookSenvice;

//显示全部书籍数据-book_zt.jsp
    @RequestMapping(value = "AdminBook.do" )
    @ResponseBody
    public Object booklike(){
        List<AdminBook> booklist = adminBookSenvice.booklist();
        JSONArray jsonArray = JSONArray.fromObject(booklist);
        return jsonArray.toString();
    }
    //模糊查询书名-book_zt.jsp
@RequestMapping(value = "AdminBookNameSelect.do")
@ResponseBody
        public  String  bookyg(@RequestParam("bookName") String bookName){
        List<AdminBook> bookyg = adminBookSenvice.bookyg(bookName);
        if (bookyg!=null) {
            JSONArray jsonArray = JSONArray.fromObject(bookyg);
            System.out.println(jsonArray);
            return jsonArray.toString();
        }
        return  null;
    }

    //书ID搜索
    @RequestMapping("AdminBookNumber.do")
    @ResponseBody
    public String  bookNumber(@RequestParam("number")String number){
        AdminBook AdminBook = adminBookSenvice.bookNumber(number);
        //判空
            if (AdminBook ==null) return null;
            //转换成json数据
        JSONArray jsonArray = JSONArray.fromObject(AdminBook);
        System.out.println(jsonArray);
        return jsonArray.toString();

    }
    //在馆数量查询 book_zt.jsp
    @RequestMapping("AdminStocksSelect.do")
    @ResponseBody
    public  String  stocksSelect(@RequestParam("min") int min,
                                 @RequestParam("max") int max){
        List<AdminBook> AdminBooks = adminBookSenvice.stockeSelect(min,max);
        JSONArray jsonArray = JSONArray.fromObject(AdminBooks);
        return jsonArray.toString();
    }
        //添加书籍 addBook.jsp
        @RequestMapping(value = "AdminAddBook.do",method = RequestMethod.POST)
        @ResponseBody
        public String intoAbook( @RequestParam("title")String title ,
                                @RequestParam("author")String author,
                                @RequestParam("publisher")String press,
                                @RequestParam("positions")String location,
                                @RequestParam("type_Number")int type_Number ,
                                @RequestParam("imgPath")String imgPath,
                                @RequestParam("publisher_Date")String publisher_Date,
                                @RequestParam("price")float price ,
                                @RequestParam("Total")int Total,
                                @RequestParam("Stocks")int Stocks,
                                @RequestParam("Synopsis")String Synopsis){
            //System.out.println(publisher_Date+"这是时间");

            AdminBook AdminBook = new AdminBook(title,author,press,location,type_Number,imgPath,publisher_Date,price,Total,Stocks,Synopsis);
            AdminBook.setPublisher_Date(publisher_Date);
            //System.out.println(AdminBook.toString());
            boolean b = adminBookSenvice.intoAbook(AdminBook);
                if (b)
            return "yes";
                return "no";
        }


        //拿到书id 并 加入 session 里 并转跳到 jsp界面
    @RequestMapping("AdminBookID.do")
    @ResponseBody
    public  String  selectBookId(@RequestParam("bookid") String booid,
                                HttpSession session ){
        AdminBook AdminBook = adminBookSenvice.bookNumber(booid);
            session.setAttribute("book", AdminBook);
            return "";
    }

    @RequestMapping("up.do")
    public  String up(){
        return "WEB-INF/admin/person/upBooks.jsp";
    }

       //修改书籍
 @RequestMapping("AdminUpBook.do")
 @ResponseBody
    public  String  upBook(@RequestParam("book_Id")String book_Id,
                           @RequestParam("title")String title ,
                           @RequestParam("author")String author,
                           @RequestParam("publisher")String press,
                           @RequestParam("positions")String location,
                           @RequestParam("type_Number")int type_Number ,
                           @RequestParam("imgPath")String imgPath,
                           @RequestParam("publisher_Date")String publisher_Date,
                           @RequestParam("price")float price ,
                           @RequestParam("Total")int Total,
                           @RequestParam("Stocks")int Stocks,
                           @RequestParam("Synopsis")String Synopsis){

     AdminBook AdminBook = new AdminBook(book_Id,title,author,press,location,type_Number,imgPath,publisher_Date,price,Total,Stocks,Synopsis);
     AdminBook.setPublisher_Date(publisher_Date);
     boolean b = adminBookSenvice.upBook(AdminBook);
            if (b) System.out.println("修改成功啦");
            else System.out.println("修改失败啦");
     return "yes";
 }
//删除书籍
    @RequestMapping("AdminDeleteBook.do")
    @ResponseBody
 public  String deleteBook(@RequestParam("bookid") String bookid){
        Boolean aBoolean = adminBookSenvice.deleteBook(bookid);
        if (aBoolean)    return "yes";
      return "no";
 }


}
