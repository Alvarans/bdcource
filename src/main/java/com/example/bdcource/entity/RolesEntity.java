package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "roles_id")
    private int roleId;
    @Column(name = "role", unique = true, nullable = false)
    private String role;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "userRole")
    Set<UserEntity> users = new HashSet<>();
}
