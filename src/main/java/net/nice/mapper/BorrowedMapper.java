package net.nice.mapper;

import net.nice.bean.Borrowed;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowedMapper {
/*    List<Borrowed> addBorrowed(Reader reader);*/

    List<Borrowed> findBorrowed(String reader_ID);

    int bookRecord(Borrowed borrowed);
}
