package com.example.bdcource.repository;

import com.example.bdcource.entity.VerificationListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationListRepository extends JpaRepository<VerificationListEntity, Integer> {
    VerificationListEntity findByVerificationId(int id);
}
