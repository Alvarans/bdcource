package com.example.bdcource.repository;

import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewId(Long id);
    List<ReviewEntity> findReviewEntitiesByUser(UserEntity user);

    List<ReviewEntity> findReviewEntitiesByUserUserId(Long userId);

    List<ReviewEntity> findReviewEntitiesByFilmFilmId(Long filmId);
}
