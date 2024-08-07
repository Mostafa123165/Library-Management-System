package com.maids.cc.Library.Management.System.mapper;

import com.maids.cc.Library.Management.System.dto.request.LiberianRequestDto;
import com.maids.cc.Library.Management.System.entities.Liberian;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LiberianMapper {

    @Mapping(target = "accessToken" , ignore = true)
    Liberian mapToLiberian(LiberianRequestDto liberianRequestDto);
}
