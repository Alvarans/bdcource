package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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
    //Reports
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "report")
    Set<ReportEntity> reports = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "commented_film", nullable = false)
    private FilmEntity commentedFilm;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    private UserEntity user;
    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "commented_review")
    private ReviewEntity commentedReview;
}
