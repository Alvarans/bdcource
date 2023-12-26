package com.example.bdcource.mapping;

import com.example.bdcource.dto.FilmDto;
import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.repository.ReviewRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmMapping {
    public FilmDto mapToFilmDto(FilmEntity entity){
        FilmDto tempDto = new FilmDto();
        tempDto.setFilmId(entity.getFilmId());
        tempDto.setFilmTitle(entity.getFilmTitle());
        tempDto.setReleaseDate(entity.getReleaseDate());
        tempDto.setDirector(entity.getDirector());
        tempDto.setFilmTiming(entity.getFilmTiming());
        tempDto.setAnnotation(entity.getAnnotation());
        tempDto.setReviewerRating(entity.getReviewerRating());
        tempDto.setUsersRating(entity.getUsersRating());
        return tempDto;
    }

    public FilmEntity mapToFilmEntity(FilmDto dto){
        FilmEntity tempEntity = new FilmEntity();
        tempEntity.setFilmId(dto.getFilmId());
        tempEntity.setFilmTitle(dto.getFilmTitle());
        tempEntity.setReleaseDate(dto.getReleaseDate());
        tempEntity.setDirector(dto.getDirector());
        tempEntity.setFilmTiming(dto.getFilmTiming());
        tempEntity.setAnnotation(dto.getAnnotation());
        tempEntity.setReviewerRating(dto.getReviewerRating());
        tempEntity.setUsersRating(dto.getUsersRating());
        return tempEntity;
    }
}
