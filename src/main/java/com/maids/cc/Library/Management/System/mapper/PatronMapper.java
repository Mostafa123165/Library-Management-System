package com.maids.cc.Library.Management.System.mapper;

import com.maids.cc.Library.Management.System.dto.request.PatronRequestDto;
import com.maids.cc.Library.Management.System.entities.Patron;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatronMapper {
    Patron mapToPatron(PatronRequestDto patronRequestDto);
}
