package com.example.bdcource.mapping;

import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserMapping {
    UserEntity mapToUserEntity(UserDto dto){
        UserEntity tempEntity = new UserEntity();
        tempEntity.setUserId(dto.getUserId());
        tempEntity.setUserNickname(dto.getUserNickname());
        tempEntity.setUserRating(dto.getUserRating());
        tempEntity.setUserEmail(dto.getUserEmail());
        return tempEntity;
    }

    UserDto mapToUserDto(UserEntity entity){
        UserDto tempDto = new UserDto();
        tempDto.setUserId(entity.getUserId());
        tempDto.setUserNickname(entity.getUserNickname());
        tempDto.setUserRating(entity.getUserRating());
        tempDto.setUserEmail(entity.getUserEmail());
        return tempDto;
    }
}
