package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "review_id")
    private long reviewId;
    @Column(name = "review_title", unique = true, nullable = false)
    private String reviewTitle;
    @Column(name = "author_organization")
    private String authorOrganization;
    @Column(name = "review_text", nullable = false)
    private String reviewText;
    @Column(name = "film_rate", nullable = false)
    private short filmRate;
    @Column(name = "review_rate")
    private short reviewRate;
    private long filmId;
    private long userId;
}
