package com.maids.cc.Library.Management.System.dto.request;


import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookRequestDto {

    @NotNull(message = "isbn is required")
    private String isbn;

    @NotNull(message = "title is required")
    private String title;

    @NotNull(message = "author is required")
    private String author;
}
