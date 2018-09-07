package net.nice.mapper;

import net.nice.bean.Staff;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffMapper {
    Staff adminLogin(Staff staff);
}
