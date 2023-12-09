package com.example.bdcource.mapping;

import com.example.bdcource.dto.FilmDto;
import com.example.bdcource.entity.FilmEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FilmMapping {
    FilmEntity toEntity(FilmDto dto);

    FilmDto toDto(FilmEntity entity);
}
