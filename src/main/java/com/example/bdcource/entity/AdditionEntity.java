package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "additions")
public class AdditionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "material_id")
    private long additionMaterialId;
    @Column(name = "material_url", nullable = false)
    private String materialUrl;
    private short additionTypeId;
    private int reviewId;
}
