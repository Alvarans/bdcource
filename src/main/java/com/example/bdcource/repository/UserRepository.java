package com.example.bdcource.repository;

import com.example.bdcource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUserId(Long userId);

    UserEntity findByUserNickname(String nickname);

    UserEntity findByUserEmail(String email);

    List<UserEntity> findAllByOrderByUserRating();

    List<UserEntity> findAllByOrderByReviewerRating();
}
