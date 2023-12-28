package com.example.bdcource.controller;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.dto.ReviewDto;
import com.example.bdcource.mapping.ReportMapping;
import com.example.bdcource.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bdcource/report")
public class ReportController {
    //@Autowired
    private final ReportService reportService;
    @Autowired
    private ReportMapping reportMapping;

    @PostMapping("/sendreport")
    public void addReport(@RequestBody ReportDto reportDto) {
        reportService.addReport(reportDto);
    }

    @GetMapping("/takereportpages")
    public List<ReportDto> takeAllReportsByPages(@RequestParam(required = false, defaultValue = "0") int page,
                                                 @RequestParam(required = false, defaultValue = "10") int size) {
        return reportService.takeAllReports(PageRequest.of(page, size)).getContent()
                .stream().map(reportMapping::mapToReportDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/takereport")
    public ReportDto takeReport(@RequestParam("id") Integer id) {
        return reportService.takeReport(id);
    }

    @GetMapping("/takereporttype")
    public String takeReportType(int typeId){
        return reportService.takeReportType(typeId);
    }

    @PostMapping("/acceptreport")
    public ResponseEntity<Integer> acceptReport(@RequestParam("id") Integer reportId, @RequestParam("rate") Integer rate){
        ReportDto reportDto = reportService.takeReport(reportId);
        String uri = "http://localhost:8080/api/bdcource/user/downgradeuser?id=" + reportDto.getReportedUser()+"&rate=" + rate;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getForObject(uri, Long.class);
        uri = "http://localhost:8080/api/bdcource/report/rejectreport?id=" + reportId;
        restTemplate.getForObject(uri, Integer.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/rejectreport")
    public ResponseEntity<Integer> rejectReport(@RequestParam("id") Integer id) {
        reportService.rejectReport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
