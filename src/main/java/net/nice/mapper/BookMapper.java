package net.nice.mapper;

import net.nice.bean.Book;
import net.nice.bean.Reader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {

    /*遍历所有书籍*/
    List<Book> allBook();

    /*遍历索引书籍*/
    List<Book> sBook();

    /*遍历文学类书籍*/
    List<Book> wxBook();

    /*遍历生活类书籍*/
    List<Book> shBook();

    /*遍历科技类书籍*/
    List<Book> kjBook();

    /*遍历历史类书籍*/
    List<Book> lsBook();

    List<Book> reacherBook(String title);

    Book BorrowBook(Integer book_ID);

    int updateStock(Book book);

}
