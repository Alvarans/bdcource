package com.example.bdcource.repository;

import com.example.bdcource.entity.ReportTypesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportTypesRepository extends JpaRepository<ReportTypesEntity, Short> {
}
