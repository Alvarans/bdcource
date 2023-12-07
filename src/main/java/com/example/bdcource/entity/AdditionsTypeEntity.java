package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "additionstype")
public class AdditionsTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int additionsTypeId;
    @Column(name = "type", unique = true, nullable = false)
    private String additionsTypeName;
    //Additions
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "additionType")
    private Set<AdditionEntity> additions = new HashSet<>();
}
