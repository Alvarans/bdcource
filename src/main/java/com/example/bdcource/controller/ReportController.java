package com.example.bdcource.controller;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.entity.ReportEntity;
import com.example.bdcource.mapping.ReportMapping;
import com.example.bdcource.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcourse/report")
public class ReportController {
    //@Autowired
    private final ReportService reportService;
    @Autowired
    private ReportMapping reportMapping;

    @GetMapping("/takereportpages")
    public List<ReportDto> takeAllReportsByPages(@RequestParam(required = false, defaultValue = "0") int page,
                                                    @RequestParam(required = false, defaultValue = "10") int size) {
        return reportService.takeAllReports(PageRequest.of(page, size)).getContent()
                .stream().map(reportMapping::mapToReportDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/rejectreport/{id}")
    public ResponseEntity<Integer> rejectReport(@PathVariable("id") Integer id) {
        reportService.rejectReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
//TODO Send to user service
    @PostMapping("/sendreport")
    public void addReport(@RequestBody ReportDto reportDto){
        reportService.addReport(reportDto);
    }

    @GetMapping("/takereport/{id}")
    public ReportDto takeReport(@PathVariable("id") Integer id){
        return reportService.takeReport(id);
    }
}
