package net.nice.mapper;


import net.nice.bean.AdminStaff;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
        //管理员登录接口
    AdminStaff AdminLogin(AdminStaff admin);

}
