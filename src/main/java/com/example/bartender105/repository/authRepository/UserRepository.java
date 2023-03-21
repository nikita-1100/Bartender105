package com.example.bartender105.repository.authRepository;

import com.example.bartender105.entity.authEntity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String name);
}
