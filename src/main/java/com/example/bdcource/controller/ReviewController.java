package com.example.bdcource.controller;

import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.mapping.ReviewMapping;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcource/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ReviewMapping reviewMapping;
    @Autowired
    private UserMapping userMapping;


    @PostMapping("/addreview")
    public ResponseEntity<Long> addReview(@RequestBody ReviewDto reviewDto) {
        try {
            reviewService.addReview(reviewDto);
            return new ResponseEntity<>(reviewDto.getReviewId(), HttpStatus.CREATED);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/takereviews")
    public List<ReviewDto> takeAllReviewsByPages(@RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "10") int size) {
        return reviewService.takeReviews(PageRequest.of(page, size)).getContent()
                .stream().map(reviewMapping::mapToReviewDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/takereview")
    public ReviewDto takeReview(@RequestParam("id") Long reviewId) {
        return reviewService.takeReviewById(reviewId);
    }

    @GetMapping("/takereviewbyfilm")
    public List<ReviewDto> takeFilmsReviews(@RequestParam("id") Long filmId) {
        return reviewService.takeFilmsReviews(filmId);
    }

    @GetMapping("/takereviewsforuser")
    public List<ReviewDto> takeReviewsForUser(@RequestParam("userid") Long user) {
        return reviewService.takeAllReviewsForUser(user)
                .stream().map(reviewMapping::mapToReviewDto)
                .collect(Collectors.toList());
    }


    @DeleteMapping("/removereview")
    public ResponseEntity<Long> removeReview(@RequestParam("id") Long reviewId) {
        reviewService.removeReviewById(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
