package com.example.bdcource.controller;

import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.mapping.ReviewMapping;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
        reviewService.addReview(reviewDto);
        return new ResponseEntity<>(reviewDto.getReviewId(), HttpStatus.CREATED);
    }

    @GetMapping("/takereview")
    public ReviewDto takeReview(@RequestParam("id") Long reviewId) {
        return reviewService.takeReviewById(reviewId);
    }

    @GetMapping("/takereviewerrate")
    public short takeReviewerRate(@RequestParam("id") Long userId) {
        String uri = "http://localhost:8080/api/bdcource/user/takeuserbyid?id=" + userId;
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.getForObject(uri, UserDto.class);
        if (userDto == null)
            return 0;
        List<ReviewEntity> reviews = reviewService.takeAllReviewsForUser(userMapping.mapToUserEntity(userDto));
        String url;
        int rating = 0;
        for (ReviewEntity review : reviews) {
            url = "http://localhost:8080/api/bdcource/rating/reviewrate?id=" + review.getReviewId();
            rating += restTemplate.getForObject(url, Integer.class);
        }
        return (short) (rating / reviews.size());
    }

    @DeleteMapping("/removereview")
    public ResponseEntity<Long> removeReview(@RequestParam("id") Long reviewId) {
        reviewService.removeReviewById(reviewId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


//    @GetMapping("/getusersreviews")
//    public List<ReviewDto> takeReviewsByUser(@RequestParam("id")Long userId){
//        String Url =
//        return reviewService.takeAllReviewsForUser(userEntity)
//                .stream().map(reviewMapping::mapToReviewDto)
//                .collect(Collectors.toList());
//    }
}
