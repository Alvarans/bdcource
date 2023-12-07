package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "typeofreports")
public class ReportTypesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int typeId;
    @Column(name = "type", unique = true)
    private String reportType;
    @Column(name = "action")
    private String reportAction;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "report")
    private Set<ReportEntity> reports = new HashSet<>();
}
