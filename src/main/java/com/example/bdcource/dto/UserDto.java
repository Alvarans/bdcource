package com.example.bdcource.dto;

import com.example.bdcource.entity.RatingEntity;
import lombok.Data;

@Data
public class UserDto {
    public long userId;
    public String userNickname;
    public short userRating;
}
