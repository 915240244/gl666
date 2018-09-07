package net.nice.mapper;


import net.nice.bean.AdminReader_info;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminReaderMapper {
//读者姓名查询
    List <AdminReader_info> readerList(String name);
    //读者身份证查询
    AdminReader_info readerId(String id);

    List<AdminReader_info> getAllReader();

}
