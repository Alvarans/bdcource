package com.example.bdcource.service;

import com.example.bdcource.dto.CommentDto;
import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import com.example.bdcource.mapping.CommentMapping;
import com.example.bdcource.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapping commentMapping;

    public void addComment(CommentDto commentDto) {
        commentRepository.save(commentMapping.mapToCommentEntity(commentDto));
    }

    public CommentDto takeCommentById(Long commentId) {
        return commentMapping.mapToCommentDto(commentRepository.findByCommentId(commentId));
    }

    public List<CommentDto> takeUserComments(UserEntity user) {
        return commentRepository.findCommentEntitiesByUser(user)
                .stream().map(commentMapping::mapToCommentDto)
                .collect(Collectors.toList());
    }

    public List<CommentDto> takeFilmComments(FilmEntity film) {
        return commentRepository.findCommentEntitiesByCommentedFilm(film)
                .stream().map(commentMapping::mapToCommentDto)
                .collect(Collectors.toList());
    }

    public List<CommentDto> takeReviewComments(ReviewEntity review) {
        return commentRepository.findCommentEntitiesByCommentedReview(review)
                .stream().map(commentMapping::mapToCommentDto)
                .collect(Collectors.toList());
    }

    public void removeComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
