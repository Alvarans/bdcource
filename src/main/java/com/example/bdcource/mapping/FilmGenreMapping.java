package com.example.bdcource.mapping;

import com.example.bdcource.dto.FilmGenreDto;
import com.example.bdcource.entity.FilmGenreEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmGenreMapping {
    FilmGenreDto toDto(FilmGenreEntity entity);

    FilmGenreEntity toEntity(FilmGenreDto dto);
}
