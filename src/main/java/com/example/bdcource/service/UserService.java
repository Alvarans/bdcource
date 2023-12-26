package com.example.bdcource.service;

import com.example.bdcource.dto.UserDto;
import com.example.bdcource.entity.UserEntity;
import com.example.bdcource.mapping.UserMapping;
import com.example.bdcource.repository.RolesRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapping userMapping;
    @Autowired
    private RolesRepository rolesRepository;

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

    public void changeUserRole(long userId, String role) {
        UserEntity user = userRepository.findByUserId(userId);
        user.setUserRole(rolesRepository.findByRole(role));
        userRepository.save(user);
    }

    public String takeUserRole(long userId){
        UserEntity user = userRepository.findByUserId(userId);
        return user.getUserRole().getRole();
    }

    public short calculateReviewerRating(List<Integer> reviewRatings) {
        short rateSum = 0;
        for (Integer rates : reviewRatings) {
            rateSum += rates;
        }
        return (short) (rateSum / reviewRatings.size());
    }

    @Scheduled(cron = "@yearly")
    public void upRate() {
        List<UserEntity> users = userRepository.findAll();
        for (UserEntity user : users) {
            user.setUserRating((short) (user.getUserRating() + 10));
        }
    }

    public List<UserDto> takeTenWorstUsers(){
        List<UserEntity> users = userRepository.findAllByOrderByUserRating();
        List<UserDto> worstUsers = new ArrayList<>();
        for (int i = 0; i < 10; ++i){
            if (i == users.size())
                break;
            worstUsers.add(userMapping.mapToUserDto(users.get(i)));
        }
        return worstUsers;
    }

    public List<UserDto> takeTenWorstReviewers(){
        List<UserEntity> users = userRepository.findAllByOrderByReviewerRating();
        List<UserDto> worstReviewers = new ArrayList<>();
        for (int i = 0; i < 5; ++i){
            if (i == users.size())
                break;
            worstReviewers.add(userMapping.mapToUserDto(users.get(i)));
        }
        return worstReviewers;
    }
}
