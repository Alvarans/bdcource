package com.example.bdcource.service;

import com.example.bdcource.entity.UserEntity;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapping userMapping;

    public UserEntity getUserById(long userId) {
        return userRepository.findByUserId(userId);
    }

    public UserEntity getUserByNickname(String nick) {
        return userRepository.findByUserNickname(nick);
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByUserEmail(email);
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
}
