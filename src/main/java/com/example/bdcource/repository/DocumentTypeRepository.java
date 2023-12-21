package com.example.bdcource.repository;

import com.example.bdcource.entity.DocumentTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentTypeEntity, Short> {
    DocumentTypeEntity findByDocumentTypeId(int id);
}
