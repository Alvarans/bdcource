package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

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
    @Column(name = "user_rating", nullable = false)
    private short userRating;
    private short userRoleId;
}
