package net.nice.service;

import net.nice.bean.Book;
import net.nice.bean.Borrowed;

import java.util.List;

public interface BorrowedService {

/*    List<Borrowed> addBorrowed(Integer pageNum, Integer pageSize, Reader reader);*/
    List<Borrowed> findBorrowed(Integer pageNum, Integer pageSize, String reader_ID);

    Book BorrowBooke(int bookID);

    boolean undateStock(Book book);
}
