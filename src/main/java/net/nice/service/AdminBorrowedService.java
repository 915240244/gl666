package net.nice.service;



import net.nice.bean.AdminBborrowed_record;
import net.nice.bean.AdminReturn_record;

import java.util.List;

public interface AdminBorrowedService {

    //显示全部申请
    List<AdminBborrowed_record> record(int give_Back);

    //姓名查询
    List<AdminBborrowed_record>  nameSelect(String title);

    //修改用户归还操作
    Boolean upback(AdminBborrowed_record AdminBborrowed_record);


    // 书名查询
    List<AdminBborrowed_record>  titleSelect(String name);

    //申请身份证查询
    List<AdminBborrowed_record>  readerId(String ID);


    //用户归还并产生一条归还记录

    Boolean returnBook(AdminReturn_record record);

    int updateBack(String borrowed_ID);
}
