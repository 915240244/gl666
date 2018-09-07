package net.nice.service.Impl;

import net.nice.bean.AdminBook;
import net.nice.mapper.AdminBookMapper;
import net.nice.service.AdminBookSenvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AdminBookImpl implements AdminBookSenvice {
    @Autowired
    private AdminBookMapper adminBookMapper;
    @Override
    public List<AdminBook> booklist() {
        System.out.println("来到了实现类");
        List<AdminBook> booklists = adminBookMapper.booklist();

        return booklists;
    }
//模糊查询搜索数据
    @Override
    public List<AdminBook> bookyg(String bookName) {

        List<AdminBook> bookyg = adminBookMapper.bookyg(bookName);
        System.out.println(bookyg+"-----------Title---拿到睡觉");
        return bookyg;
    }
    //书号查询功能 book_zt.jsp
    @Override
    public AdminBook bookNumber(String number) {
        AdminBook AdminBook = adminBookMapper.bookNumber(number);
        System.out.println("AdminBook 拿到书籍 " + AdminBook);
        return AdminBook;
    }
    //库存范围查询 book_zt.jsp
    @Override
    public List<AdminBook> stockeSelect(Integer min, Integer max) {

        List<AdminBook> AdminBooks = adminBookMapper.stockeSelect(min, max);

        return AdminBooks;
    }
//删除书籍
    @Override
    public Boolean deleteBook(String id) {
        int i = adminBookMapper.deleteBook(id);
        return i > 0;
    }


    //添加书籍
    @Override
    public boolean intoAbook(AdminBook AdminBook) {

        Integer i = adminBookMapper.intoAbook(AdminBook);
        //System.out.println(i+"这是结果");
        //System.out.println(i+"表啥插入成功为什么没有返回数据呢");
        return Objects.nonNull(i);
    }

    //修改书籍
    @Override
    public boolean upBook(AdminBook AdminBook) {

        int book1 = adminBookMapper.upBook(AdminBook);
        return  book1 > 0;
    }


}