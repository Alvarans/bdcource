package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private long userId;
    @Column(name = "user_nickname", unique = true, nullable = false)
    private String userNickname;
    @Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;
    @Column(name = "user_fio")
    private String userFio;
    @Column(name = "user_gender")
    private String gender;
    @Column(name = "user_socials")
    private String userSocials;
    //Reviews
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "review")
    @Column(name = "user_reviews")
    private Set<ReviewEntity> userReviews = new HashSet<>();
    //Comments
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "comment")
    @Column(name = "user_comments")
    private Set<CommentEntity> userComments = new HashSet<>();
    //Rates
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "rating")
    @Column(name = "user_rates")
    private Set<RatingEntity> userRates = new HashSet<>();
    @ManyToOne(fetch = FetchType.LAZY)
    private RolesEntity userRole;
}
