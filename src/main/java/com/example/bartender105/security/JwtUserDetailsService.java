package com.example.bartender105.security;

import com.example.bartender105.entity.authEntity.User;
import com.example.bartender105.security.jwt.JwtUser;
import com.example.bartender105.security.jwt.JwtUserFactory;
import com.example.bartender105.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@Slf4j
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User with username " + username+" not found");
        }
        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUserName - user with username: {} successfully loaded", username);
        return jwtUser;
    }
}
