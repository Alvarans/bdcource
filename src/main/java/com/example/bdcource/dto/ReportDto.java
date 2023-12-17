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
    String reportText;
    Timestamp reportTime;
    int reportType;
    long reportedUser;
    Long reportedComment;
    Long reportedReview;
}
