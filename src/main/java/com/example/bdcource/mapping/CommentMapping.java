package com.example.bdcource.mapping;

import com.example.bdcource.dto.CommentDto;
import com.example.bdcource.entity.CommentEntity;
import com.example.bdcource.repository.FilmRepository;
import com.example.bdcource.repository.ReviewRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentMapping {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public CommentEntity mapToCommentEntity(CommentDto dto) {
        CommentEntity tempEntity = new CommentEntity();
        tempEntity.setCommentId(dto.getCommentId());
        tempEntity.setCommentText(dto.getCommentText());
        tempEntity.setCommentTime(dto.getCommentTime());
        tempEntity.setCommentedFilm(filmRepository.findByFilmId(dto.getCommentedFilm()));
        tempEntity.setUser(userRepository.findByUserId(dto.getUser()));
        tempEntity.setCommentedReview(reviewRepository.findByReviewId(dto.getCommentedReview()));
        return tempEntity;
    }

    public CommentDto mapToCommentDto(CommentEntity entity) {
        CommentDto tempDto = new CommentDto();
        tempDto.setCommentId(entity.getCommentId());
        tempDto.setCommentText(entity.getCommentText());
        tempDto.setCommentTime(entity.getCommentTime());
        tempDto.setCommentedFilm(entity.getCommentedFilm().getFilmId());
        tempDto.setUser(entity.getUser().getUserId());
        tempDto.setCommentedReview(entity.getCommentedReview().getReviewId());
        return tempDto;
    }
}
