package com.example.bdcource.service;

import com.example.bdcource.dto.RatingDto;
import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.entity.RatingEntity;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.mapping.RatingMapping;
import com.example.bdcource.repository.RatingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingService {
    //used to map from ratingDto to ratingEntity and reverse
    @Autowired
    private RatingMapping ratingMapping;
    //used to interact with table Rating in database
    @Autowired
    private RatingRepository ratingRepository;

    //adding new rating to anything (user, film, review). Rated film and rated review can be empty
    public void addRate(RatingDto ratingDto) {
        RatingDto newRateDto = new RatingDto();
        newRateDto.setRatingValue(ratingDto.getRatingValue());
        newRateDto.setRatedUser(ratingDto.getRatedUser());
        newRateDto.setRatedFilm(ratingDto.getRatedFilm());
        newRateDto.setRatedReview(ratingDto.getRatedReview());
        ratingRepository.save(ratingMapping.mapToRatingEntity(newRateDto));
    }

    //calculate overall film rating by users ratings
    public int calculateFilmRate(FilmEntity film) {
        List<RatingEntity> ratings = ratingRepository.findRatingEntitiesByRatedFilm(film);
        if (ratings.isEmpty())
            return -1;
        int rateSum = 0;
        for (RatingEntity rate : ratings) {
            rateSum += rate.getRatingValue();
        }
        return rateSum / ratings.size();
    }

    //calculate overall review rating by users ratings
    public int calculateReviewRate(ReviewEntity review) {
        try {
            List<RatingEntity> ratings = ratingRepository.findRatingEntitiesByRatedReview(review);
            if (ratings.isEmpty())
                return -1;
            int rateSum = 0;
            for (RatingEntity rate : ratings) {
                rateSum += rate.getRatingValue();
            }
            return rateSum / ratings.size();
        } catch (Throwable throwable) {
            return 0;
        }
    }

    //Calculate overall film rating by reviews rating
    public int calculateReviewersFilmRate(List<ReviewDto> dtos){
        int rateSum = 0;
        for (ReviewDto reviewDto : dtos){
            rateSum+=reviewDto.getFilmRate();
        }
        return rateSum/ dtos.size();
    }
}
