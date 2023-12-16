package com.example.bdcource.controller;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.entity.ReportEntity;
import com.example.bdcource.mapping.ReportMapping;
import com.example.bdcource.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcourse/report")
public class ReportController {
    private ReportService reportService;
    private ReportMapping reportMapping;

    @GetMapping("takereportpages")
    public List<ReportEntity> takeAllReportsByPages(@RequestParam(required = false, defaultValue = "0") int page,
                                          @RequestParam(required = false, defaultValue = "5") int size) {
        return reportService.takeAllReports(PageRequest.of(page, size)).getContent();
    }

    @DeleteMapping("rejectreport/{id}")
    public ResponseEntity<Integer> rejectReport(@PathVariable("id") Integer id) {
        reportService.rejectReport(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
//TODO Send to user service
    @PostMapping("sendreport")
    public void addReport(@RequestBody ReportDto reportDto){
        reportService.addReport(reportDto);
    }

    @GetMapping("takereport/{id}")
    public ReportDto takeReport(int reportId){
        return reportService.takeReport(reportId);
    }
}
