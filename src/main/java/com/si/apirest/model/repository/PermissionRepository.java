package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.PermissionEntity;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Integer>{
    PermissionEntity findByNombre(String nombre);
}
