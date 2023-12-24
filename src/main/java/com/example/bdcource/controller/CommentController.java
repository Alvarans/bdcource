package com.example.bdcource.controller;

import com.example.bdcource.dto.CommentDto;
import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.dto.UserDto;
import com.example.bdcource.mapping.CommentMapping;
import com.example.bdcource.mapping.ReviewMapping;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcouce")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommentMapping commentMapping;
    @Autowired
    private ReviewMapping reviewMapping;
    @Autowired
    private UserMapping userMapping;

    @PostMapping("/addcomment")
    public ResponseEntity<Long> addComment(@RequestBody CommentDto commentDto){
        commentService.addComment(commentDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/takecomment")
    public CommentDto takeCommentById(@RequestParam("id")Long commentId){
        return commentService.takeCommentById(commentId);
    }

//    @GetMapping("/takefilmcomments")
//    public List<CommentDto> takeFilmComments(@RequestParam("id")Long filmId){
//        String uri = "http://localhost:8080/api/bdcourse/user/takeuserbyid?id=" + userId;
//        RestTemplate restTemplate = new RestTemplate();
//        UserDto userDto = restTemplate.getForObject(uri, UserDto.class);
//    }

    @GetMapping("/takereviewcomments")
    public List<CommentDto> takeReviewComments(@RequestParam("id")Long reviewId){
        String uri = "http://localhost:8080/api/bdcourse/review/takereview?id=" + reviewId;
        RestTemplate restTemplate = new RestTemplate();
        ReviewDto reviewDto = restTemplate.getForObject(uri, ReviewDto.class);
        return reviewDto != null ? commentService.takeReviewComments(reviewMapping.mapToReviewEntity(reviewDto)) : null;
    }

    @GetMapping("/takeusercomments")
    public List<CommentDto> takeUserComments(@RequestParam("id")Long userId){
        String uri = "http://localhost:8080/api/bdcourse/user/takeuserbyid?id=" + userId;
        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.getForObject(uri, UserDto.class);
        return userDto != null ? commentService.takeUserComments(userMapping.mapToUserEntity(userDto)) : null;
    }

    @DeleteMapping("/removecomment")
    public ResponseEntity<Long> removeComment(@RequestParam("id")Long commentId){
        commentService.removeComment(commentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
