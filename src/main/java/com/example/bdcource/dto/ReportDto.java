package com.example.bdcource.dto;

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
