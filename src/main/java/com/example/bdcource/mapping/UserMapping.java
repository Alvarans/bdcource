package com.example.bdcource.mapping;

import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapping {
    public UserEntity mapToUserEntity(UserDto dto){
        UserEntity tempEntity = new UserEntity();
        tempEntity.setUserId(dto.getUserId());
        tempEntity.setUserNickname(dto.getUserNickname());
        tempEntity.setUserRating(dto.getUserRating());
        tempEntity.setUserEmail(dto.getUserEmail());
        tempEntity.setReviewerRating(dto.getReviewerRating());
        return tempEntity;
    }

    public UserDto mapToUserDto(UserEntity entity){
        UserDto tempDto = new UserDto();
        tempDto.setUserId(entity.getUserId());
        tempDto.setUserNickname(entity.getUserNickname());
        tempDto.setUserRating(entity.getUserRating());
        tempDto.setUserEmail(entity.getUserEmail());
        tempDto.setReviewerRating(entity.getReviewerRating());
        return tempDto;
    }
}
