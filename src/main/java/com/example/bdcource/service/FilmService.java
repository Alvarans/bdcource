package com.example.bdcource.service;

import com.example.bdcource.dto.FilmDto;
import com.example.bdcource.dto.FilmGenreDto;
import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.mapping.FilmGenreMapping;
import com.example.bdcource.mapping.FilmMapping;
import com.example.bdcource.repository.FilmGenreRepository;
import com.example.bdcource.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmMapping filmMapping;
    @Autowired
    private FilmGenreRepository filmGenreRepository;
    @Autowired
    private FilmGenreMapping filmGenreMapping;

    public void addFilm(FilmDto filmDto) {
        filmRepository.save(filmMapping.mapToFilmEntity(filmDto));
    }

    public FilmDto takeFilmById(long filmId) {
        return filmMapping.mapToFilmDto(filmRepository.findByFilmId(filmId));
    }

    public List<FilmDto> takeFilmsByTitle(String name) {
        return filmRepository.findFilmEntitiesByFilmTitle(name)
                .stream().map(filmMapping::mapToFilmDto)
                .collect(Collectors.toList());
    }

    public void removeFilmById(long filmId) {
        filmRepository.deleteById(filmId);
    }

    public List<FilmGenreDto> takeFilmGenres(long filmId){
        return filmGenreRepository.findFilmGenreEntitiesByFilms_filmId(filmId)
                .stream().map(filmGenreMapping::mapToFilmGenreDto)
                .collect(Collectors.toList());
    }

    public List<FilmDto> takeFilmsByGenre(int filmGenreId){
        return filmRepository.findFilmEntitiesByGenres_GenreId(filmGenreId)
                .stream().map(filmMapping::mapToFilmDto)
                .collect(Collectors.toList());
    }
}
