package com.example.bdcource.controller;

import com.example.bdcource.dto.RatingDto;
import com.example.bdcource.mapping.RatingMapping;
import com.example.bdcource.service.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcourse/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private RatingMapping ratingMapping;

    @PostMapping("/addrating")
    public ResponseEntity<Integer> addRating(@RequestBody RatingDto ratingDto) {
        ratingService.addRate(ratingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/filmrate")
    public int takeFilmRate(@RequestParam("id") Long id) {
        return ratingService.calculateFilmRate(id);
    }

    @GetMapping("/reviewrate")
    public int takeReviewRate(@RequestParam("id") Long id) {
        return ratingService.calculateReviewRate(id);
    }
}
