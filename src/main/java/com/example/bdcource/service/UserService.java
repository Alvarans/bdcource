package com.example.bdcource.service;

import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.UserEntity;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapping userMapping;

    public void addUser(UserDto userDto) {
        userRepository.save(userMapping.mapToUserEntity(userDto));
    }

    public UserEntity getUserById(long userId) {
        return userRepository.findByUserId(userId);
    }

    public UserEntity getUserByNickname(String nick) {
        return userRepository.findByUserNickname(nick);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }

    public void downgradeUser(long userId, short rateValue) {
        UserEntity user = userRepository.findByUserId(userId);
        short newRateValue = (short) (user.getUserRating() - rateValue);
        if (newRateValue > 0)
            user.setUserRating(newRateValue);
        else
            user.setUserRating((short) 0);
        userRepository.save(user);
    }

    public short calculateReviewerRating(List<Integer> reviewRatings) {
        short rateSum = 0;
        for (Integer rates : reviewRatings) {
            rateSum += rates;
        }
        return (short) (rateSum / reviewRatings.size());
    }
}
