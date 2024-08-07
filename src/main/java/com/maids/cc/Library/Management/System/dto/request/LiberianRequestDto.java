package com.maids.cc.Library.Management.System.dto.request;

import com.maids.cc.Library.Management.System.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class LiberianRequestDto {

    @NotBlank(message = "username is required")
    private String username;

    @Email(message = "email is not validate")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    private Role role;

}
