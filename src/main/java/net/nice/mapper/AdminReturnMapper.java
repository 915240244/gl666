package net.nice.mapper;


import net.nice.bean.AdminReturn_record;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminReturnMapper {
//书名查询
    List<AdminReturn_record> booname(String title);

    //人名查询
    List<AdminReturn_record> seleectName(String name);

    //显示全部记录
    List <AdminReturn_record> recordList();

    int insertInfo(AdminReturn_record AdminReturn_record);




}
