package net.nice.service.Impl;

import com.github.pagehelper.PageHelper;
import net.nice.bean.Book;
import net.nice.bean.Borrowed;
import net.nice.mapper.BookMapper;
import net.nice.mapper.BorrowedMapper;
import net.nice.service.BorrowedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowedServiceImpl implements BorrowedService {
    @Autowired
    BorrowedMapper borrowedMapper;
   @Autowired
    BookMapper bookMapper;
/*    @Override
    public List<Borrowed> addBorrowed(Integer pageNum, Integer pageSize,Reader reader) {
        PageHelper.startPage(pageNum,pageSize);
        List<Borrowed> borroweds = this.borrowedMapper.addBorrowed(reader);
        return borroweds;
    }*/


    @Override
    public List<Borrowed> findBorrowed(Integer pageNum, Integer pageSize, String reader_ID){
        PageHelper.startPage(pageNum,pageSize);
        return borrowedMapper.findBorrowed(reader_ID);
    }

    @Override
    public Book BorrowBooke(int book_ID) {

        return bookMapper.BorrowBook(book_ID);
    }

    @Override
    public boolean undateStock(Book book){
        int count=bookMapper.updateStock(book);
        if (count==1){
            return true;
        }
        return false;
    }




}
