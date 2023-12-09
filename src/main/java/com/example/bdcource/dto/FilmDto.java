package com.example.bdcource.dto;

import lombok.Data;

@Data
public class FilmDto {
    String filmTitle;
    short releaseDate;
    String director;
    short filmTiming;
    String annotation;
    short reviewerRating;
    short usersRating;
}
