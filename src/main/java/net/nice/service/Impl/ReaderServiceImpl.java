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

}
