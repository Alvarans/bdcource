package com.example.bdcource.service;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.entity.ReportEntity;
import com.example.bdcource.mapping.ReportMapping;
import com.example.bdcource.mapping.ReportTypesMapping;
import com.example.bdcource.repository.ReportRepository;
import com.example.bdcource.repository.ReportTypesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final ReportMapping reportMapping;
    private final ReportTypesRepository reportTypesRepository;
    private final ReportTypesMapping reportTypesMapping;

    public void addReport(ReportDto reportDto){
        reportRepository.save(reportMapping.mapToReportEntity(reportDto));
    }
    public ReportEntity takeReport(int reportId){
        return reportRepository.getByReportId(reportId);
    }

    public void rejectReport(int reportId){
        reportRepository.deleteById(reportId);
    }
}
