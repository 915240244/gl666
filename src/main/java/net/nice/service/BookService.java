package net.nice.service;

import net.nice.bean.Book;

import java.util.List;

public interface BookService {

    //int findCount();

    /*遍历所有书籍*/
    List<Book> allBook(Integer pageNum, Integer pageSize);

    /*根据索引查询*/
    //int sCount();

    /*遍历索引书籍*/
    List<Book> sBook(Integer pageNum, Integer pageSize);

    /*遍历文学书籍*/
    List<Book> wxBook(Integer pageNum, Integer pageSize);

    /*遍历生活类书籍*/
    List<Book> shBook(Integer pageNum, Integer pageSize);

    /*遍历科技类书籍*/
    List<Book> kjBook(Integer pageNum, Integer pageSize);

    /*遍历历史类书籍*/
    List<Book> lsBook(Integer pageNum, Integer pageSize);


    List<Book> searchBook(String title);


}
