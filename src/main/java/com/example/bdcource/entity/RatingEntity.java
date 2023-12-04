package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "rating")
public class RatingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "rating_id")
    private long ratingId;
    @Column(name = "rating_type", nullable = false)
    private String ratingType;
    @Column(name = "rating_value", nullable = false)
    private short ratingValue;

    private long filmId;
    private long userId;
    private long reviewId;
}
