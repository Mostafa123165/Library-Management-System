package com.maids.cc.Library.Management.System.controller;

import com.maids.cc.Library.Management.System.dto.request.LiberianRequestDto;
import com.maids.cc.Library.Management.System.dto.request.LoginRequestDto;
import com.maids.cc.Library.Management.System.dto.response.AuthenticationResponseDto;
import com.maids.cc.Library.Management.System.dto.response.MessageResponseDto;
import com.maids.cc.Library.Management.System.entities.Liberian;
import com.maids.cc.Library.Management.System.service.LiberianService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class LiberianController {

    private final LiberianService liberianService;


    @PostMapping("/register")
    public ResponseEntity<Object> registerAdmin(@Valid @RequestBody LiberianRequestDto liberianRequestDto) {
        Liberian liberian = liberianService.registerAdmin(liberianRequestDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        MessageResponseDto.builder()
                                .status(HttpStatus.CREATED.value())
                                .message("Add liberian Successfully - " + liberian.getId())
                                .build()
                );
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDto> login(@Valid @RequestBody LoginRequestDto loginRequestDto) {
        AuthenticationResponseDto authenticationResponseDto = liberianService.login(loginRequestDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(authenticationResponseDto);
    }
}
