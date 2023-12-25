package com.example.bdcource.repository;

import com.example.bdcource.entity.AdditionsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionsTypeRepository extends JpaRepository<AdditionsTypeEntity, Integer> {
    AdditionsTypeEntity findByAdditionsTypeId(int id);
}
