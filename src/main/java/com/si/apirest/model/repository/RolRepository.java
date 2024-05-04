package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.si.apirest.model.entity.RoleEntity;

public interface RolRepository extends JpaRepository<RoleEntity, Integer>{
    
}
