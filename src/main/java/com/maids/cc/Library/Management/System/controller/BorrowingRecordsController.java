package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.dto.response.MessageResponseDto;
import com.maids.cc.Library.Management.System.entities.BorrowingRecord;
import com.maids.cc.Library.Management.System.repository.BorrowingRecordRepository;
import com.maids.cc.Library.Management.System.service.BorrowingRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/borrow")
public class BorrowingRecordsController {

    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/{bookId}/patron/{patronId}")
    public ResponseEntity<MessageResponseDto> borrowBook(@PathVariable("bookId") Long bookId ,
                                                         @PathVariable("patronId") Long patronId) {

        borrowingRecordService.borrowBook(bookId,patronId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("The book with ID " + bookId + " has been successfully borrowed by the patron with ID " + patronId + ".")
                        .build()
                );
    }

    //public void returnBook() {}

}
