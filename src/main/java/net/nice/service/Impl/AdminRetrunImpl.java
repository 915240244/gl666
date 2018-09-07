package net.nice.service.Impl;



import net.nice.bean.AdminReturn_record;
import net.nice.service.AdminRetrunService;
import net.nice.mapper.AdminReturnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminRetrunImpl implements AdminRetrunService {

    @Autowired
    AdminReturnMapper mapper;
    @Override
    public List<AdminReturn_record> booname(String title) {

        List<AdminReturn_record> booname = mapper.booname(title);
        return booname;

    }

    @Override
    public List<AdminReturn_record> readerName(String name) {
        List<AdminReturn_record> recordList = mapper.seleectName(name);
        return recordList;
    }

    @Override
    public List<AdminReturn_record> recordList() {

        List<AdminReturn_record> recordList = mapper.recordList();
        return recordList;
    }

    @Override
    public int insertInfo(AdminReturn_record AdminReturn_record) {


        return mapper.insertInfo(AdminReturn_record);
    }
}
