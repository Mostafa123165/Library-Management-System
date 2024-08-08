package com.maids.cc.Library.Management.System.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatronRequestDto {

    private Long id;

    @NotBlank(message = "name is required")
    private String name ;

    @NotBlank(message = "email is required")
    @Email(message = "email format is not valid")
    private String email;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "phone is required")
    private String phone;
}
