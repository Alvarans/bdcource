package com.example.bdcource.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDto {
    Long commentId;
    String commentText;
    Timestamp commentTime;
    Long commentedFilm;
    Long user;
    Long commentedReview;
}
