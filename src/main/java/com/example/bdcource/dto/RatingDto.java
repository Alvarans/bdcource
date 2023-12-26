package com.example.bdcource.dto;

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
