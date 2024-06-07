package com.example.bdcource.service;

import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import com.example.bdcource.mapping.ReviewMapping;
import com.example.bdcource.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ReviewMapping reviewMapping;

    public void addReview(ReviewDto reviewDto) {
        reviewRepository.save(reviewMapping.mapToReviewEntity(reviewDto));
    }

    public void removeReviewById(long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public ReviewDto takeReviewById(long reviewId) {
        return reviewMapping.mapToReviewDto(reviewRepository.findByReviewId(reviewId));
    }

    public List<ReviewDto> takeFilmsReviews(long filmId) {
        return reviewRepository.findReviewEntitiesByFilmFilmId(filmId)
                .stream().map(reviewMapping::mapToReviewDto)
                .collect(Collectors.toList());
    }
    public Page<ReviewEntity> takeReviews(PageRequest pageRequest) {
        return reviewRepository.findAll(pageRequest);
    }

    public List<ReviewEntity> takeAllReviewsForUser(UserEntity userEntity) {
        return reviewRepository.findReviewEntitiesByUser(userEntity);
    }
}
