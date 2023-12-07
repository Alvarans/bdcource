package com.example.bdcource.repository;

import com.example.bdcource.entity.FilmGenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmGenreRepository extends JpaRepository<FilmGenreEntity, Short> {
}
