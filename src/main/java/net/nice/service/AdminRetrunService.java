package net.nice.service;



import net.nice.bean.AdminReturn_record;

import java.util.List;

public interface AdminRetrunService {

    List<AdminReturn_record> booname(String title);

    //人名查询
    List<AdminReturn_record> readerName(String name);

    //显示全部记录
    List <AdminReturn_record> recordList();

    int insertInfo(AdminReturn_record AdminReturn_record);
}
