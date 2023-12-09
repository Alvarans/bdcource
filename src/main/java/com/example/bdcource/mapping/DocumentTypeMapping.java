package com.example.bdcource.mapping;

import com.example.bdcource.dto.DocumentTypeDto;
import com.example.bdcource.entity.DocumentTypeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeMapping {
    public DocumentTypeEntity mapToDocumentTypeEntity(DocumentTypeDto dto){
        DocumentTypeEntity tempEntity = new DocumentTypeEntity();
        tempEntity.setDocumentTypeId(dto.getDocumentTypeId());
        tempEntity.setDocumentName(dto.getDocumentName());
        return tempEntity;
    }
}
