package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
@Entity
@Data
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comment_id")
    private long commentId;
    @Column(name = "comment_text", nullable = false)
    private String commentText;
    @Column(name = "comment_time", nullable = false)
    private Timestamp commentTime;
    private long filmId;
    private long userId;
    private long reviewId;
}
