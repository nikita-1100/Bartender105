package com.example.bartender105.entity.authEntity;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User extends AuthBaseEntity {
    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
