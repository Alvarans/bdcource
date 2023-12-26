package com.example.bdcource.dto;

import lombok.Data;

@Data
public class VerificationListDto {
    int verificationId;
    String verificationText;
    Long user;
    Integer documentType;
}
