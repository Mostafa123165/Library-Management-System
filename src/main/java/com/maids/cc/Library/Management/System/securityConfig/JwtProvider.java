package com.maids.cc.Library.Management.System.securityConfig;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class JwtProvider {


    final private JwtEncoder jwtEncoder;
    final private JwtDecoder jwtDecoder;

    public String generateJwt(Authentication authentication) {

        User user = (User) authentication.getPrincipal();

        JwtClaimsSet jwtClaimsSet = JwtClaimsSet
                .builder()
                .issuedAt(Instant.now())
                .expiresAt(Instant.now().plusSeconds(60 * 60 * 24 * 30 * 12))
                .claim("email", user.getUsername())
                .claim("authorities", user.getAuthorities())
                .build();

        return  this.jwtEncoder
                .encode(JwtEncoderParameters.from(jwtClaimsSet))
                .getTokenValue() ;
    }

    public String validateJwt(String jwt) {
        return this.jwtDecoder
                .decode(jwt)
                .getClaimAsString("email") ;
    }

}
