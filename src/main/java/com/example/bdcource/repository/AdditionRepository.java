package com.example.bdcource.repository;

import com.example.bdcource.entity.AdditionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionRepository extends JpaRepository<AdditionEntity, Long> {
}
