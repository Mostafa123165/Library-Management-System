package com.maids.cc.Library.Management.System.mapper;

import com.maids.cc.Library.Management.System.dto.request.BookRequestDto;
import com.maids.cc.Library.Management.System.entities.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    Book mapToBook(BookRequestDto bookDto);
}
