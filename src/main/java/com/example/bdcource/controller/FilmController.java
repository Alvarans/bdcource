package com.example.bdcource.controller;

import com.example.bdcource.dto.FilmDto;
import com.example.bdcource.mapping.FilmMapping;
import com.example.bdcource.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcource/film")
public class FilmController {
    @Autowired
    private FilmService filmService;
    @Autowired
    private FilmMapping filmMapping;

    @PostMapping("/addfilm")
    public ResponseEntity<Long> addFilm(@RequestBody FilmDto filmDto){
        filmService.addFilm(filmDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/takefilm")
    public FilmDto takeFilmById(@RequestParam("id")Long filmId){
        return filmService.takeFilmById(filmId);
    }

    @GetMapping("/takefilmsbytitle")
    public List<FilmDto> takeFilmsByTitle(@RequestParam("title")String title){
        return filmService.takeFilmsByTitle(title);
    }

    @DeleteMapping("/removefilm")
    public ResponseEntity<Long> removeFilm(@RequestParam("id")Long filmId){
        filmService.removeFilmById(filmId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
