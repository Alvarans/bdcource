package com.example.bdcource.dto;

import lombok.Data;

@Data
public class UserDto {
    long userId;
    String userNickname;
    String userEmail;
    short userRating;
}
