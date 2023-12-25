package com.example.bdcource.dto;

import com.example.bdcource.entity.AdditionsTypeEntity;
import com.example.bdcource.entity.ReviewEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class AdditionDto {
    Long additionMaterialId;
    String materialUrl;
    Integer additionType;
    Long review;
}
