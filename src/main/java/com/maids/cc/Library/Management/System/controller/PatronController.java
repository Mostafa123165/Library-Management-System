package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.dto.request.BookRequestDto;
import com.maids.cc.Library.Management.System.dto.request.PatronRequestDto;
import com.maids.cc.Library.Management.System.dto.response.MessageResponseDto;
import com.maids.cc.Library.Management.System.entities.Book;
import com.maids.cc.Library.Management.System.entities.Patron;
import com.maids.cc.Library.Management.System.service.PatronService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/patrons")
public class PatronController {

    private final PatronService patronService;

    @GetMapping("/")
    public ResponseEntity<List<Patron>> findAllBook() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patronService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> findPatronById(@PathVariable("id") Long id) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patronService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<MessageResponseDto> addNewPatron(@Valid @RequestBody PatronRequestDto patronRequestDto) {

        Patron patron = patronService.addNewPatron(patronRequestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("Add patron Successfully - " + patron.getId())
                        .build()
                );
    }

    @PutMapping("/")
    public ResponseEntity<MessageResponseDto> update(@Valid @RequestBody PatronRequestDto patronRequestDto) {

        Patron patron = patronService.update(patronRequestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("Update patron Successfully - " + patron.getId())
                        .build()
                );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponseDto> delete(@PathVariable("id") Long id) {

        patronService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(MessageResponseDto.builder()
                        .status(HttpStatus.OK.value())
                        .message("Delete patron Successfully - " + id)
                        .build()
                );
    }


}
