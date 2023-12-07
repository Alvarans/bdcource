package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "filmgenres")
public class FilmGenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int genreId;
    @Column(name = "genre_name", nullable = false, unique = true)
    private String genreName;
    @ManyToMany(mappedBy = "genres")
    private Set<FilmEntity> films = new HashSet<>();
}
