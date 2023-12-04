package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private short roles_id;
    @Column(name = "role", unique = true, nullable = false)
    private String role;
}
