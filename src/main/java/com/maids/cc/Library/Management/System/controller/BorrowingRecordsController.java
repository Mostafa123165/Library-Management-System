package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.dto.response.MessageResponseDto;
import com.maids.cc.Library.Management.System.service.BorrowingRecordService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BorrowingRecordsController {

    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
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

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<MessageResponseDto> returnBook(@PathVariable("bookId") Long bookId ,
                           @PathVariable("patronId") Long patronId) {


       borrowingRecordService.returnBook(bookId,patronId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("The book with ID " + bookId + " has been successfully returned by the patron with ID " + patronId + ".")
                        .build()
                );
    }

}
