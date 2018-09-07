package net.nice.service.Impl;

import com.github.pagehelper.PageHelper;
import net.nice.bean.Book;
import net.nice.mapper.BookMapper;
import net.nice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;

/*    @Override
    public int findCount() {
        return this.bookMapper.findCount();
    }*/

    @Override
    public List<Book> allBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> bookList=bookMapper.allBook();
        return bookList;
    }


/*    @Override
    public int sCount() {
        return this.bookMapper.sCount();
    }*/
    /**
     * 按照输入的用户名模糊查询出用户
     */
    @Override
    public List<Book> searchBook(String title){

        title=new StringBuilder().append("%").append(title).append("%").toString();
        List<Book> bookList=bookMapper.reacherBook(title);
        return bookList;
    }

    @Override
    public List<Book> sBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books = this.bookMapper.sBook();
        return books;
    }

    @Override
    public List<Book> wxBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> wxBook = this.bookMapper.wxBook();
        return wxBook;
    }

    @Override
    public List<Book> shBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> shBook = this.bookMapper.shBook();
        return shBook;
    }

    @Override
    public List<Book> kjBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> kjBook = this.bookMapper.kjBook();
        return kjBook;
    }

    @Override
    public List<Book> lsBook(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> lsBook = this.bookMapper.lsBook();
        return lsBook;
    }


}
