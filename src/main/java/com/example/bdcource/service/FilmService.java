package com.example.bdcource.service;

import com.example.bdcource.dto.FilmDto;
import com.example.bdcource.mapping.FilmMapping;
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

    public void addFilm(FilmDto filmDto){
        filmRepository.save(filmMapping.mapToFilmEntity(filmDto));
    }

    public FilmDto takeFilmById(long filmId){
        return filmMapping.mapToFilmDto(filmRepository.findByFilmId(filmId));
    }

    public List<FilmDto> takeFilmsByName(String name){
        return filmRepository.findFilmEntitiesByFilmTitle(name)
                .stream().map(filmMapping::mapToFilmDto)
                .collect(Collectors.toList());
    }

    public void removeFilmById(long filmId){
        filmRepository.deleteById(filmId);
    }
}
