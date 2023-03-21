package com.example.bartender105.repository.authRepository;

import com.example.bartender105.entity.authEntity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
