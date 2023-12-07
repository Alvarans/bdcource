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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    private AdditionsTypeEntity additionType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    private ReviewEntity review;
}
