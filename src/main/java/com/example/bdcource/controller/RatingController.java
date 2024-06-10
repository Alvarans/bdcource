package com.example.bdcource.controller;

import com.example.bdcource.dto.FilmDto;
import com.example.bdcource.dto.RatingDto;
import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.mapping.FilmMapping;
import com.example.bdcource.mapping.RatingMapping;
import com.example.bdcource.mapping.ReviewMapping;
import com.example.bdcource.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcource/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private FilmMapping filmMapping;
    @Autowired
    private ReviewMapping reviewMapping;
    @Autowired
    private RatingMapping ratingMapping;

    @PostMapping("/addrating")
    public ResponseEntity<Integer> addRating(@RequestBody RatingDto ratingDto) {
        ratingService.addRate(ratingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/filmrate")
    public int takeFilmRate(@RequestParam("id") Long filmId) {
        String uri = "http://localhost:8080/api/bdcource/film/takefilm?id=" + filmId;
        RestTemplate restTemplate = new RestTemplate();
        FilmDto filmDto = restTemplate.getForObject(uri, FilmDto.class);
        return filmDto != null
                ? ratingService.calculateFilmRate(filmMapping.mapToFilmEntity(filmDto))
                : 0;
    }

    @GetMapping("/filmreviewerrate")
    public int takeReviewerFilmRate(@RequestParam("id") Long filmId) {
        String uri = "http://localhost:8080/api/bdcource/review/takereviewbyfilm?id=" + filmId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ReviewDto[]> response = restTemplate.getForEntity(uri,ReviewDto[].class);
        List<ReviewDto> reviewDtos = List.of(response.getBody());
        return ratingService.calculateReviewersFilmRate(reviewDtos);
    }

    @GetMapping("/reviewrate")
    public int takeReviewRate(@RequestParam("id") Long reviewId) {
        String uri = "http://localhost:8080/api/bdcource/review/takereview?id=" + reviewId;
        RestTemplate restTemplate = new RestTemplate();
        ReviewDto reviewDto = restTemplate.getForObject(uri, ReviewDto.class);
        return reviewDto != null
                ? ratingService.calculateReviewRate(reviewMapping.mapToReviewEntity(reviewDto))
                : 0;
    }

    @GetMapping("/takereviewerrate")
    public short takeReviewerRate(@RequestParam("id") Long userId) {
        String uri = "http://localhost:8080/api/bdcource/user/takeuserbyid?id=" + userId;
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.getForObject(uri, UserDto.class);
        if (userDto == null)
            return 0;
        uri = "http://localhost:8080/api/bdcource/review/takereviewsforuser?userid=" + userId;
        ResponseEntity<ReviewDto[]> response = restTemplate.getForEntity(uri,ReviewDto[].class);
        if (response.getBody() == null)
            return 0;
        List<ReviewDto> reviews = List.of(response.getBody());
        return (short) ratingService.calculateReviewerRate(reviews);
    }
}
