package com.application.four.security;

import com.application.four.entity.Users;
import com.application.four.exception.UserNotFound;
import com.application.four.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotFound(String.format("User with email: %s is not found", email))
        );

        Set<String> roles = new HashSet<String>();
        roles.add("ROLE_ADMIN");
        return new User(user.getEmail(), user.getPassword(),userAuthorities(roles));
    }

    public Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles) {
        return roles.stream().map(
                role -> new SimpleGrantedAuthority(role)
                ).collect(Collectors.toList());
    }
}
