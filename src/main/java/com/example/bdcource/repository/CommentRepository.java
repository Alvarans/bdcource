package com.example.bdcource.repository;

import com.example.bdcource.entity.CommentEntity;
import com.example.bdcource.entity.FilmEntity;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    CommentEntity findByCommentId(Long id);

    List<CommentEntity> findCommentEntitiesByUser(UserEntity user);

    List<CommentEntity> findCommentEntitiesByCommentedFilm(FilmEntity film);

    List<CommentEntity> findCommentEntitiesByCommentedReview(ReviewEntity review);
}
