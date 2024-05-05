package com.si.apirest.model.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.RolePermissionEntity;
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Integer> {

    @Query(value = "{call GetPermissionsByRoleId(:idIn)}", nativeQuery = true)
    List<String> getPermissionsByRoleId(@Param("idIn") int idIn );
}
