package net.nice.service.Impl;


import net.nice.bean.AdminReader_info;
import net.nice.mapper.AdminReaderMapper;
import net.nice.service.AdminReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminReaderImpl implements AdminReaderService {
    @Autowired
    AdminReaderMapper AdminReaderMapper;

    @Override
    public List<AdminReader_info> readerList(String name) {
        List<AdminReader_info> readerList = AdminReaderMapper.readerList(name);
        return readerList;
    }

    @Override
    public AdminReader_info readerId(String id) {
        AdminReader_info id1 = AdminReaderMapper.readerId(id);
return id1;
    }

    @Override
    public List<AdminReader_info> getAllReader() {

        List<AdminReader_info> adminReader_infoList = AdminReaderMapper.getAllReader();
        return adminReader_infoList;
    }
}
