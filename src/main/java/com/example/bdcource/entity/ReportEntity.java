package com.example.bdcource.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Data
@Table(name = "report")
public class ReportEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "report_id")
    private int reportId;
    @Column(name = "report_text", nullable = false)
    private int reportText;
    @Column(name = "report_time")
    private Timestamp report_time;
    private int typeId;
    private int commentId;
    private int reviewId;
}
