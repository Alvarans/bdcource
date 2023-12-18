package com.example.bdcource.controller;

import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcourse/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapping userMapping;

    @PostMapping("/adduser")
    public ResponseEntity<Long> addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/takeuserbyid")
    public UserDto takeUserById(@RequestParam("id")Long userId){
        UserEntity user = userService.getUserById(userId);
        String uri = "http://localhost:8080/api/bdcourse/review/takereviewerrate?id="+userId;
        RestTemplate restTemplate = new RestTemplate();
        user.setReviewerRating(restTemplate.getForObject(uri, Short.class));
        return userMapping.mapToUserDto(user);
    }

    @GetMapping("/takeuserbynickname")
    public UserDto takeUserByNickname(@RequestParam("nickname")String nickname){
        UserEntity user = userService.getUserByNickname(nickname);
        String uri = "http://localhost:8080/api/bdcourse/review/takereviewerrate?id="+user.getUserId();
        RestTemplate restTemplate = new RestTemplate();
        user.setReviewerRating(restTemplate.getForObject(uri, Short.class));
        return userMapping.mapToUserDto(user);
    }

    @GetMapping("/takeuserbyemail")
    public UserDto takeUserByEmail(@RequestParam("email")String email){
        UserEntity user = userService.getUserByEmail(email);
        String uri = "http://localhost:8080/api/bdcourse/review/takereviewerrate?id="+user.getUserId();
        RestTemplate restTemplate = new RestTemplate();
        user.setReviewerRating(restTemplate.getForObject(uri, Short.class));
        return userMapping.mapToUserDto(userService.getUserByEmail(email));
    }

    @PostMapping("/downgradeUser")
    public ResponseEntity<Long> downgradeUser(@RequestParam("id")Long id, @RequestParam("rate")short rate){
        userService.downgradeUser(id, rate);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/removeuser")
    public ResponseEntity<Long> removeUser(@RequestParam("id")Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
