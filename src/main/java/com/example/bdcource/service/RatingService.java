package com.example.bdcource.service;

import com.example.bdcource.dto.RatingDto;
import com.example.bdcource.mapping.RatingMapping;
import com.example.bdcource.repository.FilmRepository;
import com.example.bdcource.repository.RatingRepository;
import com.example.bdcource.repository.ReviewRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RatingService {
    final private RatingMapping ratingMapping;
    final private RatingRepository ratingRepository;
    final private FilmRepository filmRepository;
    final private UserRepository userRepository;
    final private ReviewRepository reviewRepository;

    public void addRate(short rate, long userId, long filmId, Long reviewId) {
        RatingDto newRateDto = new RatingDto();
        newRateDto.setRatingValue(rate);
        newRateDto.setRatedUser(userRepository.findByUserId(userId));
        newRateDto.setRatedFilm(filmRepository.findByFilmId(filmId));
        if (reviewId != null) {
            newRateDto.setRatedReview(reviewRepository.FindByReviewId(reviewId));
        } else {
            newRateDto.setRatedReview(null);
        }
        ratingRepository.save(ratingMapping.mapToRatingEntity(newRateDto));
    }


}
