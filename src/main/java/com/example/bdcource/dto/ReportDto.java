package com.example.bdcource.dto;

import com.example.bdcource.entity.CommentEntity;
import com.example.bdcource.entity.ReportTypesEntity;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.entity.UserEntity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReportDto {
    int reportId;
    int reportText;
    Timestamp reportTime;
    ReportTypesEntity reportType;
    UserEntity reportedUser;
    CommentEntity reportedComment;
    ReviewEntity reportedReview;
}
