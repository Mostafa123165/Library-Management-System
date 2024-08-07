package com.maids.cc.Library.Management.System.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDto {
    private int status;
    private String message;
}
