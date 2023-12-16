package com.example.bdcource.service;

import com.example.bdcource.mapping.FilmMapping;
import com.example.bdcource.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {
    private FilmRepository filmRepository;
    private FilmMapping filmMapping;
}
