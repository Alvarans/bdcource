package com.example.bdcource.mapping;

import com.example.bdcource.dto.VerificationListDto;
import com.example.bdcource.entity.VerificationListEntity;
import com.example.bdcource.repository.DocumentTypeRepository;
import com.example.bdcource.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationListMapping {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public VerificationListDto mapToVerificationListDto(VerificationListEntity entity) {
        VerificationListDto tempDto = new VerificationListDto();
        tempDto.setVerificationId(entity.getVerificationId());
        tempDto.setVerificationText(entity.getVerificationText());
        tempDto.setDocumentType(entity.getDocumentType().getDocumentTypeId());
        tempDto.setUser((entity.getUser().getUserId()));
        return tempDto;
    }

    public VerificationListEntity mapToVerificationListEntity(VerificationListDto dto) {
        VerificationListEntity tempEntity = new VerificationListEntity();
        tempEntity.setVerificationId(dto.getVerificationId());
        tempEntity.setVerificationText(dto.getVerificationText());
        tempEntity.setDocumentType(documentTypeRepository.findByDocumentTypeId(dto.getDocumentType()));
        tempEntity.setUser(userRepository.findByUserId(dto.getUser()));
        return tempEntity;
    }
}
