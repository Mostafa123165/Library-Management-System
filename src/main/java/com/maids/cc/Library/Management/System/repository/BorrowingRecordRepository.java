package com.maids.cc.Library.Management.System.repository;

import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Integer> {
     boolean existsByBook(Book book);
}
