package net.nice.service;

import net.nice.bean.Reader;

import java.util.List;

public interface ReaderService {
    /*判断注册成功否*/
    boolean createReader(Reader reader);

    /*判断该身份是否注册*/
    boolean checkExist(String reader_ID);

    /*登录*/
    Reader login(Reader reader);

    /*修改用户信息*/
    boolean updateReaderInfo(Reader reader);

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
