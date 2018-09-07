package net.nice.mapper;

import net.nice.bean.Reader;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReaderMapper {
    /*注册*/
    int createReader(Reader reader);

    /*检测用户是否存在*/
    Reader checkExist(String reader_ID);

    /*登录*/
    Reader checkLogin(Reader reader);

    /*修改个人信息*/
    int updateReaderInfo(Reader reader);

    /*修改个人头像*/
    int uploadLogo(Reader reader);

    /*查询个人借阅记录*/
    Reader querylog(Reader reader);

    Reader ShowUser(String reader_ID);



    /*后台管理员部分*/
    //读者姓名查询
    List<Reader> readerList(String name);
    //读者身份证查询
    Reader readerId(String id);

    List<Reader> getAllReader();
}