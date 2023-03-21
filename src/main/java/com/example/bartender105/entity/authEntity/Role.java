package com.example.bartender105.entity.authEntity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="roles")
@Data
public class Role extends AuthBaseEntity {
    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id: " + super.getId() + ", " +
                "name: " + name + "}";
    }
}
