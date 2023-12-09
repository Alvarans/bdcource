package com.example.bdcource.mapping;

import com.example.bdcource.dto.ReportDto;
import com.example.bdcource.entity.ReportEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportMapping {
    ReportDto toDto(ReportEntity entity);

    ReportEntity toEntity(ReportDto dto);
}
