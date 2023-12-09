package com.example.bdcource.service;

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
}
