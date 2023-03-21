package com.example.bartender105.controller;

import com.example.bartender105.DTO.AutoDto.AuthRequestDto;
import com.example.bartender105.DTO.AutoDto.ResponseDto;
import com.example.bartender105.entity.authEntity.User;
import com.example.bartender105.security.jwt.JwtTokenProvider;
import com.example.bartender105.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/login/")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider provider;
    private final UserService userService;

    @PostMapping("auth")
    public ResponseEntity<ResponseDto> login(@RequestBody AuthRequestDto requestDto){
        try{
            String username = requestDto.getUsername();
            User user = userService.findByUsername(username);
            if (user==null){
                throw new UsernameNotFoundException("User with username "+ username+ " not found");
            }
            String token = provider.createToken(user);
            ResponseDto response = new ResponseDto(token,username);
            return ResponseEntity.of(Optional.of(response));
        } catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid login or password");
        }
    }

}
