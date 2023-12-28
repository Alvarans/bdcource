package com.example.bdcource.service;

import com.example.bdcource.dto.RatingDto;
import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.entity.RatingEntity;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.mapping.RatingMapping;
import com.example.bdcource.repository.FilmRepository;
import com.example.bdcource.repository.RatingRepository;
import com.example.bdcource.repository.ReviewRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    @Autowired
    private RatingMapping ratingMapping;
    @Autowired
    private RatingRepository ratingRepository;

    public void addRate(RatingDto ratingDto) {
        RatingDto newRateDto = new RatingDto();
        newRateDto.setRatingValue(ratingDto.getRatingValue());
        newRateDto.setRatedUser(ratingDto.getRatedUser());
        newRateDto.setRatedFilm(ratingDto.getRatedFilm());
        newRateDto.setRatedReview(ratingDto.getRatedReview());
        ratingRepository.save(ratingMapping.mapToRatingEntity(newRateDto));
    }

    public int calculateFilmRate(FilmEntity film) {
        List<RatingEntity> ratings = ratingRepository.findRatingEntitiesByRatedFilm(film);
        if (ratings.isEmpty())
            return 0;
        int rateSum = 0;
        for (RatingEntity rate : ratings) {
            rateSum += rate.getRatingValue();
        }
        return rateSum / ratings.size();
    }

    public int calculateReviewRate(ReviewEntity review) {
        try {
            List<RatingEntity> ratings = ratingRepository.findRatingEntitiesByRatedReview(review);
            if (ratings.isEmpty())
                return 0;
            int rateSum = 0;
            for (RatingEntity rate : ratings) {
                rateSum += rate.getRatingValue();
            }
            return rateSum / ratings.size();
        } catch (Throwable throwable) {
            return 0;
        }
    }
}
