package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.dto.request.BookRequestDto;
import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.service.BookService;
import com.maids.cc.Library.Management.System.dto.response.MessageResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public Book findBookById(@PathVariable("id") Long id) {
        System.out.println(id);
        return bookService.findById(id);
    }

    @PostMapping("/")
    public MessageResponseDto add(@Valid @RequestBody BookRequestDto bookDto) {

        Book book = bookService.addNewBook(bookDto);
        return MessageResponseDto.builder()
                .status(HttpStatus.ACCEPTED.value())
                .message("Add book Successfully - " + book.getId())
                .build();
    }

    //public void update(@Valid @RequestBody BookDto bookDto) {}

    //public void deleteById(@PathVariable("id") Long id) {}


}
