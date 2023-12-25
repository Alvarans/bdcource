package com.example.bdcource.service;

import com.example.bdcource.dto.AdditionDto;
import com.example.bdcource.entity.ReviewEntity;
import com.example.bdcource.mapping.AdditionMapping;
import com.example.bdcource.repository.AdditionRepository;
import com.example.bdcource.repository.AdditionsTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdditionService {
    @Autowired
    private AdditionRepository additionRepository;
    @Autowired
    private AdditionMapping additionMapping;
    @Autowired
    private AdditionsTypeRepository additionsTypeRepository;

    public void addAdditionToReview(AdditionDto additionDto){
        additionRepository.save(additionMapping.mapToAdditionEntity(additionDto));
    }

    public List<AdditionDto> takeReviewAdditions(ReviewEntity review){
        return additionRepository.findAdditionEntitiesByReview(review)
                .stream().map(additionMapping::mapToAdditionDto)
                .collect(Collectors.toList());
    }

    public void removeAdditionById(long additionId){
        additionRepository.deleteById(additionId);
    }

    public String takeAdditionType(int additionTypeId){
        return additionsTypeRepository.findByAdditionsTypeId(additionTypeId).getAdditionsTypeName();
    }
}
