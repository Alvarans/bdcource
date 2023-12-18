package com.example.bdcource.controller;

import com.example.bdcource.dto.UserDto;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcourse/user/")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapping userMapping;

    @PostMapping("/adduser")
    public ResponseEntity<Long> addReport(@RequestBody UserDto userDto){
        userService.addUser(userDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/takeuserbyid")
    public UserDto takeUserById(@RequestParam("id")Long id){
        return userMapping.mapToUserDto(userService.getUserById(id));
    }

    @GetMapping("/takeuserbynickname")
    public UserDto takeUserByNickname(@RequestParam("nickname")String nickname){
        return userMapping.mapToUserDto(userService.getUserByNickname(nickname));
    }

    @GetMapping("/takeuserbyemail")
    public UserDto takeUserByEmail(@RequestParam("email")String email){
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
