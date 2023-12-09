package com.example.bdcource.mapping;

import com.example.bdcource.dto.VerificationListDto;
import com.example.bdcource.entity.VerificationListEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VerificationListMapping {
    VerificationListDto toDto(VerificationListEntity entity);

    VerificationListEntity toEntity(VerificationListDto dto);
}
