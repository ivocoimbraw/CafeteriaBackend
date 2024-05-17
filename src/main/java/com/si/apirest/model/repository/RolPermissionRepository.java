package com.si.apirest.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.RolePermissionEntity;
import com.si.apirest.model.entity.RolePermissionId;

@Repository
public interface RolPermissionRepository extends JpaRepository<RolePermissionEntity,RolePermissionId >{
    @Query("SELECT rp FROM RolePermissionEntity rp WHERE rp.rol.id = :idRol")
    List<RolePermissionEntity> findByPermiso(Integer idRol);
}
