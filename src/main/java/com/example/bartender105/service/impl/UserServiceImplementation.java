package com.example.bartender105.service.impl;

import com.example.bartender105.entity.authEntity.Role;
import com.example.bartender105.entity.authEntity.Status;
import com.example.bartender105.entity.authEntity.User;
import com.example.bartender105.repository.authRepository.RoleRepository;
import com.example.bartender105.repository.authRepository.UserRepository;
import com.example.bartender105.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(User user) {
        Role roleUser = roleRepo.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);
        user.setStatus(Status.ACTIVE);
        User registeredUser = userRepo.save(user);
        log.info("IN register - user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        User result = userRepo.findById(id).orElse(null);
        if (result==null)
            log.info("IN findById - no user found by id {}",id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepo.deleteById(id);
        log.info("IN delete - user with id {} deleted",id);
    }
}
