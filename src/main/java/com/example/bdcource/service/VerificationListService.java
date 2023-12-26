package com.example.bdcource.service;

import com.example.bdcource.dto.VerificationListDto;
import com.example.bdcource.entity.VerificationListEntity;
import com.example.bdcource.mapping.VerificationListMapping;
import com.example.bdcource.repository.DocumentTypeRepository;
import com.example.bdcource.repository.VerificationListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerificationListService {
    @Autowired
    private VerificationListRepository verificationListRepository;
    @Autowired
    private VerificationListMapping verificationListMapping;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public void addVerification(VerificationListDto verificationListDto){
        verificationListRepository.save(verificationListMapping.mapToVerificationListEntity(verificationListDto));
    }
    public VerificationListDto takeVerification(int verificationId) {
        return verificationListMapping.mapToVerificationListDto(verificationListRepository.findByVerificationId(verificationId));
    }

    public List<VerificationListDto> takeAllVerifications() {
        return verificationListRepository.findAll()
                .stream().map(verificationListMapping::mapToVerificationListDto)
                .collect(Collectors.toList());
    }

    public void rejectVerification(int verificationId) {
        verificationListRepository.deleteById(verificationId);
    }

    public String takeDocumentType(int verificationId){
        VerificationListEntity verificationListEntity = verificationListRepository.findByVerificationId(verificationId);
        return verificationListEntity.getDocumentType().getDocumentName();
    }
}
