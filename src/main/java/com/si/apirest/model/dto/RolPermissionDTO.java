package com.si.apirest.model.dto;

import java.util.List;

import com.si.apirest.model.entity.PermissionEntity;
import com.si.apirest.model.entity.RoleEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RolPermissionDTO {
    private RoleEntity rol;
    private List<PermissionEntity> permisos;
}
