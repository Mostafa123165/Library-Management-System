package com.maids.cc.Library.Management.System.service;

import com.maids.cc.Library.Management.System.dto.request.LiberianRequestDto;
import com.maids.cc.Library.Management.System.dto.request.LoginRequestDto;
import com.maids.cc.Library.Management.System.dto.response.AuthenticationResponseDto;
import com.maids.cc.Library.Management.System.entities.Liberian;
import com.maids.cc.Library.Management.System.exceptions.BadRequestException;
import com.maids.cc.Library.Management.System.mapper.LiberianMapper;
import com.maids.cc.Library.Management.System.repository.LiberianRepository;
import com.maids.cc.Library.Management.System.securityConfig.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LiberianService {

    private final LiberianRepository liberianRepository;
    private final LiberianMapper liberianMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    @Transactional
    public Liberian registerAdmin(LiberianRequestDto liberianRequestDto) {

        if (liberianRepository.findByEmail(liberianRequestDto.getEmail()).isPresent()) {
            throw new BadRequestException("The email address provided is already in use. Please try another email address.");
        }

        liberianRequestDto.setPassword(bCryptPasswordEncoder.encode(liberianRequestDto.getPassword()));

        Liberian liberian = liberianMapper.mapToLiberian(liberianRequestDto);

        return liberianRepository.save(liberian);
    }


    @Transactional
    public AuthenticationResponseDto login(LoginRequestDto loginRequestDto) {
        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequestDto.getEmail(),
                        loginRequestDto.getPassword())
        );

        String token = jwtProvider.generateJwt(authenticate);

        return AuthenticationResponseDto
                .builder()
                .status(HttpStatus.OK.value())
                .message("Logged in successfully")
                .token(token)
                .build();
    }


}
