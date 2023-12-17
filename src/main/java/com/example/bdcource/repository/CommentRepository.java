package com.example.bdcource.repository;

import com.example.bdcource.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    CommentEntity findByCommentId(Long id);
}
