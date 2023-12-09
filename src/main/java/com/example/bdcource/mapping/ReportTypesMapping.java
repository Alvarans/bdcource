package com.example.bdcource.mapping;

import com.example.bdcource.dto.ReportTypesDto;
import com.example.bdcource.entity.ReportTypesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReportTypesMapping {
    ReportTypesDto toDto(ReportTypesEntity entity);

    ReportTypesEntity toEntity(ReportTypesDto dto);
}
