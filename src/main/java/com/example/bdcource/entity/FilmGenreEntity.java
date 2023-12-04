package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "filmgenres")
public class FilmGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private short genreId;
    @Column(name = "genre_name", nullable = false, unique = true)
    private String genreName;
}
