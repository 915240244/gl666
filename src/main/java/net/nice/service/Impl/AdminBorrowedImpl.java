package net.nice.service.Impl;

import net.nice.bean.AdminBborrowed_record;

import net.nice.mapper.AdminBorrowedMapper;
import net.nice.service.AdminBorrowedService;
import net.nice.bean.AdminReturn_record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminBorrowedImpl implements AdminBorrowedService {


    @Autowired
    AdminBorrowedMapper AdminBorrowedMapper;

    @Override
    public List<AdminBborrowed_record> record(int give_Back) {
        List<AdminBborrowed_record> record = AdminBorrowedMapper.record(give_Back);

        return record;
    }

    @Override
    public List<AdminBborrowed_record> nameSelect(String title) {

        List<AdminBborrowed_record> AdminBborrowed_records = AdminBorrowedMapper.nameSelect(title);

        return AdminBborrowed_records;
    }

    @Override
    public Boolean upback(AdminBborrowed_record AdminBborrowed_record) {
        int upback = AdminBorrowedMapper.upback(AdminBborrowed_record);
        return upback > 0;
    }

    @Override
    public List<AdminBborrowed_record> titleSelect(String name) {

        List<AdminBborrowed_record> AdminBborrowed_records = AdminBorrowedMapper.titleSelect(name);

        return AdminBborrowed_records;
    }

    @Override
    public List<AdminBborrowed_record> readerId(String ID) {

        List<AdminBborrowed_record> AdminBborrowed_records = AdminBorrowedMapper.readerId(ID);

        return AdminBborrowed_records;
    }

    @Override
    public Boolean returnBook(AdminReturn_record record) {

        int i = AdminBorrowedMapper.returnBook(record);
        return i > 0;
    }

    @Override
    public int updateBack(String borrowed_ID) {


        return AdminBorrowedMapper.updateBack(borrowed_ID);
    }
}
