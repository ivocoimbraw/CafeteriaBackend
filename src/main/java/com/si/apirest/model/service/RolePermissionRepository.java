package com.si.apirest.model.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.si.apirest.model.entity.RolePermissionEntity;

public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {

    @Query("SELECT rp FROM RolePermissionEntity rp WHERE rp.rol.id = :idRol")
    Iterable<RolePermissionEntity> findByPermiso(Integer idRol);
}
