package net.nice.service;



import net.nice.bean.AdminBook;

import java.util.List;

public interface AdminBookSenvice {
//显示全部书籍数据
    List<AdminBook> booklist();
    //搜索单个
    List<AdminBook> bookyg(String bookName);

    //书号查询功能 book_zt.jsp
    AdminBook bookNumber(String number);

    //库存范围查询 book_zt.jsp
    List <AdminBook> stockeSelect(Integer min, Integer max);

    //删除书籍 book_zt.jsp
    Boolean deleteBook(String id);


    //添加书籍 addBook.sjp
    boolean intoAbook(AdminBook AdminBook);

    //修改图书数据 upBook.jsp
    boolean upBook(AdminBook AdminBook);



}
