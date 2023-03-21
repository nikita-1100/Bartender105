package com.example.bartender105.config;

import com.example.bartender105.security.jwt.JwtConfigurer;
import com.example.bartender105.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtTokenProvider provider;
    private static final String[] ANONYMOUS_ENDPOINT = {"/login/**"};
    private static final String[] ADMIN_ENDPOINT = {"/specification/**"};
    private static final String[] LOGIN_ENDPOINT = {"/cocktail/**"};




    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .requestMatchers(ANONYMOUS_ENDPOINT).permitAll()
                .requestMatchers(LOGIN_ENDPOINT).hasRole("USER")
                .requestMatchers(ADMIN_ENDPOINT).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigurer(provider));
        return http.build();
    }
}
