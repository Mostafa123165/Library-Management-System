package com.maids.cc.Library.Management.System.service;

import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.entities.BorrowingRecord;
import com.maids.cc.Library.Management.System.entities.Patron;
import com.maids.cc.Library.Management.System.exceptions.BadRequestException;
import com.maids.cc.Library.Management.System.repository.BorrowingRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class BorrowingRecordService {

    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookService bookService ;
    private final PatronService patronService;

    @Transactional
    public void borrowBook(Long bookId, Long patronId) {
        Book book = bookService.findById(bookId);
        Patron patron = patronService.findById(patronId);

        if(borrowingRecordRepository.existsByPatronAndBook(patron,book)) {
            throw new BadRequestException("Book with ID " + bookId + " is already borrowed by " + patron.getName());
        }

        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowingDate(LocalDateTime.now());

        borrowingRecordRepository.save(borrowingRecord);
    }
}
