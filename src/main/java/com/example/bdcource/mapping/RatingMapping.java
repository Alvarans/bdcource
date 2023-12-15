package com.example.bdcource.mapping;

import com.example.bdcource.dto.RatingDto;
import com.example.bdcource.entity.RatingEntity;
import org.springframework.stereotype.Service;

@Service
public class RatingMapping {
    public RatingDto mapToRatingDto(RatingEntity entity){
        RatingDto tempDto = new RatingDto();
        tempDto.setRatingId(entity.getRatingId());
        //tempDto.setRatingType(entity.getRatingType());
        tempDto.setRatingValue(entity.getRatingValue());
        tempDto.setRatedFilm(entity.getRatedFilm());
        tempDto.setRatedUser(entity.getRatedUser());
        tempDto.setRatedReview(entity.getRatedReview());
        return tempDto;
    }

    public RatingEntity mapToRatingEntity(RatingDto dto){
        RatingEntity tempEntity = new RatingEntity();
        tempEntity.setRatingId(dto.getRatingId());
        //tempEntity.setRatingType(dto.getRatingType());
        tempEntity.setRatingValue(dto.getRatingValue());
        tempEntity.setRatedFilm(dto.getRatedFilm());
        tempEntity.setRatedUser(dto.getRatedUser());
        tempEntity.setRatedReview(dto.getRatedReview());
        return tempEntity;
    }
}
