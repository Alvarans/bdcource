package com.example.bdcource.dto;

import com.example.bdcource.entity.DocumentTypeEntity;
import com.example.bdcource.entity.UserEntity;
import lombok.Data;

@Data
public class VerificationListDto {
    int verificationId;
    String verificationText;
    UserEntity user;
    DocumentTypeEntity documentType;
}
