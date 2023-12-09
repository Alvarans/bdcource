package com.example.bdcource.dto;

import com.example.bdcource.entity.CommentEntity;
import com.example.bdcource.entity.ReportTypesEntity;
import com.example.bdcource.entity.ReviewEntity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ReportDto {
    int reportId;
    int reportText;
    Timestamp reportTime;
    ReportTypesEntity reportType;
    CommentEntity reportedComment;
    ReviewEntity reportedReview;
}
