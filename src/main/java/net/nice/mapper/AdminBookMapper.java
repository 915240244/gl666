package net.nice.mapper;


import net.nice.bean.AdminBook;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminBookMapper {

    //查询全部数据
    List<AdminBook> booklist();

    //书名查询 book_zt.jsp
    List<AdminBook> bookyg(String bookName);

    //书ID查询功能 book_zt.jsp
    AdminBook bookNumber(String number);

    //库存范围查询 book_zt.jsp
    List <AdminBook> stockeSelect(Integer mi, Integer mx);

    //删除书籍 book_zt.jsp
    int deleteBook(String id);

    //插入一条数据 addBook.jsp
    Integer intoAbook(AdminBook AdminBook);


    //修改图书数据 upBook.jsp
    int upBook(AdminBook AdminBook);


}
