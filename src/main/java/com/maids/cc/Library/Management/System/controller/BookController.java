package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.dto.request.BookRequestDto;
import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.service.BookService;
import com.maids.cc.Library.Management.System.dto.response.MessageResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @GetMapping("/")
    public List<Book> findAllBook() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<MessageResponseDto> add(@Valid @RequestBody BookRequestDto bookDto) {

        Book book = bookService.addNewBook(bookDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("Add book Successfully - " + book.getId())
                        .build()
                );
    }

    @PutMapping("/")
    public ResponseEntity<MessageResponseDto> update(@Valid @RequestBody BookRequestDto bookDto) {

        Book book = bookService.update(bookDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("Updated book Successfully - " + book.getId())
                        .build()
                );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> delete(@PathVariable Long id) {

        bookService.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("deleted book Successfully - " + id)
                        .build()
                );
    }


}
