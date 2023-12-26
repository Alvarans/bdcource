package com.example.bdcource.controller;

import com.example.bdcource.dto.AdditionDto;
import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.mapping.AdditionMapping;
import com.example.bdcource.mapping.ReviewMapping;
import com.example.bdcource.service.AdditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcource/addition")
public class AdditionController {
    @Autowired
    private AdditionService additionService;
    @Autowired
    private AdditionMapping additionMapping;
    @Autowired
    private ReviewMapping reviewMapping;

    @PostMapping("/addnewaddition")
    public ResponseEntity<Integer> addAddition(@RequestBody AdditionDto additionDto) {
        additionService.addAdditionToReview(additionDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/takereviewadditions")
    public List<AdditionDto> takeReviewAdditions(@RequestParam("id") Long reviewId) {
        String uri = "http://localhost:8080/api/bdcourse/review/takereview?id=" + reviewId;
        RestTemplate restTemplate = new RestTemplate();
        ReviewDto reviewDto = restTemplate.getForObject(uri, ReviewDto.class);
        return reviewDto != null
                ? additionService.takeReviewAdditions(reviewMapping.mapToReviewEntity(reviewDto))
                : null;
    }

    @GetMapping("/takeadditiontype")
    public String takeAdditionType(@RequestParam("id")int additionTypeId){
        return additionService.takeAdditionType(additionTypeId);
    }

    @DeleteMapping("/removeaddition")
    public ResponseEntity<Integer> removeAddition(@RequestParam("id")int additionId){
        additionService.removeAdditionById(additionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
