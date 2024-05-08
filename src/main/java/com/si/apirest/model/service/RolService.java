package com.si.apirest.model.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.RolDTO;
import com.si.apirest.model.entity.RoleEntity;
import com.si.apirest.model.entity.RolePermissionEntity;
import com.si.apirest.model.repository.PermissionRepository;
import com.si.apirest.model.repository.RolRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolService {
    
    @Autowired
    private final RolRepository rolRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final RolePermissionRepository rolePermissionRepository;

    @Autowired
    private final PermissionRepository permissionRepository;

    public RoleEntity crearRol(RolDTO roleEntity) {
        RoleEntity rol= rolRepository.save(modelMapper.map(roleEntity, RoleEntity.class));
        rolePermissionRepository.save(RolePermissionEntity.builder()
        .rol(rol)
        .permiso(permissionRepository.findByNombre("VER_HOME")).build()
        );
        return rol;
    }

    public RoleEntity updateRol(int id, RoleEntity roleEntity) {
        return rolRepository.findById(id).map(rol -> {
            modelMapper.map(roleEntity, rol);
            return rol;
        }).orElseThrow(() -> new EntityNotFoundException("Rol not found with id: "+id));
    }

    public RoleEntity getRol(int id){
        return rolRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Rol not found with id: "+id));
    }

    public List<RoleEntity> getAllRol() {
        return rolRepository.findAll();
    }

    public void deleteRol(int id) {
        rolRepository.deleteById(id);
    }

}
