package com.example.bdcource.dto;

import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import lombok.Data;

@Data
public class RatingDto {
    long ratingId;
    //String ratingType;
    short ratingValue;
    Long ratedFilm;
    Long ratedUser;
    Long ratedReview;
    //FilmEntity ratedFilm;
    //UserEntity ratedUser;
    //ReviewEntity ratedReview;
}
