package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "film")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "film_id")
    private long filmId;
    @Column(name = "film_title", nullable = false)
    private String filmTitle;
    @Column(name = "release_date", nullable = false)
    private short releaseDate;
    @Column(name = "director", nullable = false)
    private String Director;
    @Column(name = "film_timing", nullable = false)
    private short filmTiming;
    @Column(name = "annotation", nullable = false)
    private String annotation;
    @Column(name = "reviewer_rating")
    private short reviewerRating;
    @Column(name = "users_rating")
    private short usersRating;

}
