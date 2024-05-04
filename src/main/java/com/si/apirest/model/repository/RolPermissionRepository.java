package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.RolePermissionEntity;
import com.si.apirest.model.entity.RolePermissionId;

@Repository
public interface RolPermissionRepository extends JpaRepository<RolePermissionEntity,RolePermissionId >{
    
}
