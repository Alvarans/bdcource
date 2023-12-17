package com.example.bdcource.repository;

import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.entity.RatingEntity;
import com.example.bdcource.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
    List<RatingEntity> findRatingEntitiesByRatedFilm(FilmEntity film);

    List<RatingEntity> findRatingEntitiesByRatedReview(ReviewEntity review);
}
