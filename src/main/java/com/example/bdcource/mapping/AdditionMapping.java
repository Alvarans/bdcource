package com.example.bdcource.mapping;

import com.example.bdcource.dto.AdditionDto;
import com.example.bdcource.entity.AdditionEntity;
import com.example.bdcource.repository.AdditionsTypeRepository;
import com.example.bdcource.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdditionMapping {
    @Autowired
    private AdditionsTypeRepository additionsTypeRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    public AdditionEntity mapToAdditionEntity(AdditionDto dto) {
        AdditionEntity tempEntity = new AdditionEntity();
        tempEntity.setAdditionMaterialId(dto.getAdditionMaterialId());
        tempEntity.setMaterialUrl(dto.getMaterialUrl());
        tempEntity.setAdditionType(additionsTypeRepository.findByAdditionsTypeId(dto.getAdditionType()));
        tempEntity.setReview(reviewRepository.findByReviewId(dto.getReview()));
        return tempEntity;
    }

    public AdditionDto mapToAdditionDto(AdditionEntity entity) {
        AdditionDto tempDto = new AdditionDto();
        tempDto.setAdditionMaterialId(entity.getAdditionMaterialId());
        tempDto.setMaterialUrl(entity.getMaterialUrl());
        tempDto.setAdditionType(entity.getAdditionType().getAdditionsTypeId());
        tempDto.setReview(entity.getReview().getReviewId());
        return tempDto;
    }
}
