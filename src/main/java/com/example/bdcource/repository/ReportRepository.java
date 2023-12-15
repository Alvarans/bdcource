package com.example.bdcource.repository;

import com.example.bdcource.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportEntity, Integer> {
    ReportEntity getByReportId(Integer reportId);
}
