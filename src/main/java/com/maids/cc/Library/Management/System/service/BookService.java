package com.maids.cc.Library.Management.System.service;

import com.maids.cc.Library.Management.System.dto.request.BookRequestDto;
import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.exceptions.BadRequestException;
import com.maids.cc.Library.Management.System.exceptions.NotFoundCustomException;
import com.maids.cc.Library.Management.System.mapper.BookMapper;
import com.maids.cc.Library.Management.System.repository.BookRepository;
import com.maids.cc.Library.Management.System.repository.BorrowingRecordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BorrowingRecordRepository borrowingRecordRepository;
    private final BookMapper bookMapper;


    @Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book findById(Long id) {

        return checkBookIsExistedByIdOrThrowException(id);
    }

    @Transactional
    public Book addNewBook(BookRequestDto bookDto) {

        checkBookIsNotExistedByIsbnOrThrowException(bookDto.getIsbn());
        Book book = bookMapper.mapToBook(bookDto);

        return bookRepository.save(book);
    }


    @Transactional
    public Book update(BookRequestDto bookDto) {

        checkBookIsExistedByIdOrThrowException(bookDto.getId());
        Book book = bookMapper.mapToBook(bookDto);
        book.setId(bookDto.getId());

        return bookRepository.save(book);
    }

    @Transactional
    public void deleteById(Long id) {

        Book book = checkBookIsExistedByIdOrThrowException(id);

        if(borrowingRecordRepository.existsByBook(book)) {
            throw new BadRequestException("The book is currently borrowed and cannot be deleted.");
        }

        bookRepository.deleteById(id);
    }

    public Book checkBookIsExistedByIdOrThrowException(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new NotFoundCustomException("Book with Id " + id + " not found"));
    }

    public void checkBookIsNotExistedByIsbnOrThrowException(String isbn) {
        if (bookRepository.findByIsbn(isbn).isPresent()) {
            throw new NotFoundCustomException("Book with ISBN " + isbn + " already exists.");
        }
    }

}
