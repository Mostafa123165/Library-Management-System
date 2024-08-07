package com.maids.cc.Library.Management.System.service;

import com.maids.cc.Library.Management.System.entities.Liberian;
import com.maids.cc.Library.Management.System.enums.Role;
import com.maids.cc.Library.Management.System.repository.LiberianRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {


    private LiberianRepository liberianRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Liberian> liberian = liberianRepository.findByEmail(username);
        liberian.orElseThrow(() ->  new BadCredentialsException("Incorrect username or password.")) ;

        return new org.springframework.security.core.userdetails.User(
                liberian.get().getEmail(),
                liberian.get().getPassword(),
                getAuthorities(liberian.get().getRole())
        );

    }

    Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

}
