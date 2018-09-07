package net.nice.service.Impl;

import net.nice.bean.Reader;
import net.nice.mapper.ReaderMapper;
import net.nice.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    ReaderMapper readerMapper;

    @Override
    public boolean createReader(Reader reader) {
        int count=this.readerMapper.createReader(reader);
        return count>0;
    }

    @Override
    public boolean checkExist(String reader_ID) {
        Reader reader = this.readerMapper.checkExist(reader_ID);
        return Objects.nonNull(reader);
    }

    @Override
    public Reader login(Reader reader) {
        Reader reader1 = this.readerMapper.checkLogin(reader);
        return reader1;
    }

    @Override
    public boolean updateReaderInfo(Reader reader) {
        int count = this.readerMapper.updateReaderInfo(reader);
        return count>0;
    }

    @Override
    public int uploadLogo(Reader reader) {
        return this.readerMapper.uploadLogo(reader);
    }

    @Override
    public Reader querylog(Reader reader) {
        return this.readerMapper.querylog(reader);
    }

    @Override
    public Reader ShowUser(String reader_ID) {


        return readerMapper.ShowUser(reader_ID);

    }


    /*后台管理员部分*/
    @Override
    public List<Reader> readerList(String name) {
        List<Reader> readerList = this.readerMapper.readerList(name);
        return readerList;
    }

    @Override
    public Reader readerId(String id) {
        Reader readerId = this.readerMapper.readerId(id);
        return readerId;
    }

    @Override
    public List<Reader> getAllReader() {
        List<Reader> allReader = this.readerMapper.getAllReader();
        return allReader;
    }

}
