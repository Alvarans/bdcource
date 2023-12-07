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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private FilmEntity ratedFilm;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity ratedUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", referencedColumnName = "review_id")
    private ReviewEntity ratedReview;
}
