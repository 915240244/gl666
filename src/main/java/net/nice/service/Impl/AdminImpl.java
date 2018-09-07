package net.nice.service.Impl;

import net.nice.bean.AdminStaff;
import net.nice.mapper.AdminMapper;
import net.nice.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminImpl implements AdminService {
@Autowired
AdminMapper AdminMapper;

    @Override
    public AdminStaff AdminLogin(AdminStaff admin) {

        AdminStaff AdminStaff = AdminMapper.AdminLogin(admin);
        return AdminStaff;
    }
}
