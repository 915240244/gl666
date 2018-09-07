package net.nice.service;



import net.nice.bean.AdminReader_info;

import java.util.List;

public interface AdminReaderService {

    //读者姓名查询
    List<AdminReader_info> readerList(String name);

    //读者身份证查询
    AdminReader_info readerId(String id);

    List<AdminReader_info> getAllReader();

}
