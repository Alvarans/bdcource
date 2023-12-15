package com.example.bdcource.mapping;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.entity.ReportEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class ReportMapping {
    public ReportDto mapToReportDto(ReportEntity entity){
        ReportDto tempDto = new ReportDto();
        tempDto.setReportId(entity.getReportId());
        tempDto.setReportText(entity.getReportText());
        tempDto.setReportTime(entity.getReportTime());
        tempDto.setReportType(entity.getReportType());
        tempDto.setReportedReview(entity.getReportedReview());
        tempDto.setReportedComment(entity.getReportedComment());
        return tempDto;
    }

    public ReportEntity mapToReportEntity(ReportDto dto){
        ReportEntity tempEntity = new ReportEntity();
        tempEntity.setReportId(dto.getReportId());
        tempEntity.setReportText(dto.getReportText());
        tempEntity.setReportTime(dto.getReportTime());
        tempEntity.setReportType(dto.getReportType());
        tempEntity.setReportedReview(dto.getReportedReview());
        tempEntity.setReportedComment(dto.getReportedComment());
        return tempEntity;
    }

}
