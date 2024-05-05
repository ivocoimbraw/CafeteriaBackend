package com.si.apirest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.PermissionEntity;
import com.si.apirest.model.entity.Person;
import com.si.apirest.model.repository.PermissionRepository;
import com.si.apirest.model.repository.PersonRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionService {
    
    @Autowired
    private final PermissionRepository permissionRepository;

    @Autowired 
    private final ModelMapper modelMapper;

    @Autowired
    private final PersonRepository personRepository;

    @Autowired
    private final RolePermissionRepository rolePermissionRepository;

    public PermissionEntity crearPermiso(PermissionEntity permissionEntity) {
        return permissionRepository.save(permissionEntity);
    }

    public PermissionEntity updatePermiso(int id, PermissionEntity permissionEntity) {
        Optional<PermissionEntity> repoPermissionEntity = permissionRepository.findById(id);
        return repoPermissionEntity.map(permission -> {
            modelMapper.map(permissionEntity, permission);
            return permissionRepository.save(permission);
        }).orElseThrow(() -> new EntityNotFoundException("Permission not found with id: " + id));

    }

    public PermissionEntity getPermiso(int id) {
        return permissionRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Permission not found with id: " + id));
    }

    public List<PermissionEntity> getAllPermission() {
        return permissionRepository.findAll();
    }

    
    public List<String> userPermissionList(String username) {
        List<String> permissionList = new ArrayList<>();

        int idRol = personRepository.findByUsuario(username).get().getRole().getId();
        permissionList=rolePermissionRepository.getPermissionsByRoleId(idRol);

        return permissionList;
    }

    public List<String> userPermissionList(Person user) {
        List<String> permissionList = new ArrayList<>();

        int idRol = user.getRole().getId();
        permissionList=rolePermissionRepository.getPermissionsByRoleId(idRol);

        return permissionList;
    }


}
