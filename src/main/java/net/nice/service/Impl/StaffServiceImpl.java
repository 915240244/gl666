package net.nice.service.Impl;

import net.nice.bean.Staff;
import net.nice.mapper.StaffMapper;
import net.nice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffMapper staffMapper;

    @Override
    public Staff adminLogin(Staff staff) {
        Staff adminLogin = this.staffMapper.adminLogin(staff);
        return adminLogin;
    }


}
