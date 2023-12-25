package com.example.bdcource.repository;

import com.example.bdcource.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
    RolesEntity findByRoleId(short id);

    RolesEntity findByRole(String role);
}
