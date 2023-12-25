package com.example.bdcource.repository;

import com.example.bdcource.entity.AdditionEntity;
import com.example.bdcource.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdditionRepository extends JpaRepository<AdditionEntity, Long> {
    List<AdditionEntity> findAdditionEntitiesByReview(ReviewEntity review);
}
