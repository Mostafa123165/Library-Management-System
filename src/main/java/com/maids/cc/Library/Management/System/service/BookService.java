package com.maids.cc.Library.Management.System.service;

import com.maids.cc.Library.Management.System.dto.request.BookRequestDto;
import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.mapper.BookMapper;
import com.maids.cc.Library.Management.System.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;


    @Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public Book addNewBook(BookRequestDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        return bookRepository.save(book);
    }


}
