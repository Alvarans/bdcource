package com.example.bdcource.mapping;

import com.example.bdcource.dto.FilmGenreDto;
import com.example.bdcource.entity.FilmGenreEntity;

public class FilmGenreMapping {
    FilmGenreDto mapToFilmGenreDto(FilmGenreEntity entity) {
        FilmGenreDto tempDto = new FilmGenreDto();
        tempDto.setGenreId(entity.getGenreId());
        tempDto.setGenreName(entity.getGenreName());
        return tempDto;
    }

    FilmGenreEntity mapToFilmGenreEntity(FilmGenreDto dto) {
        FilmGenreEntity tempEntity = new FilmGenreEntity();
        tempEntity.setGenreId(dto.getGenreId());
        tempEntity.setGenreName(dto.getGenreName());
        //TODO FilmsfromID
        return tempEntity;
    }
}
