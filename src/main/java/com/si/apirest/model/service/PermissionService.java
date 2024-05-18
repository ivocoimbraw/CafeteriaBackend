package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.PermissionDTO;
import com.si.apirest.model.dto.RolPerDTO;
import com.si.apirest.model.entity.PermissionEntity;
import com.si.apirest.model.entity.Person;
import com.si.apirest.model.entity.RoleEntity;
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

        RoleEntity rol = personRepository.findByUsuario(username).get().getRole();

        RolPerDTO rolPerDTO = modelMapper.map(rol, RolPerDTO.class);

        List<String> permissionList = rolPerDTO.getPermissions().stream()
                                                                .map(PermissionDTO::getNombre)
                                                                .collect(Collectors.toList());

        return permissionList;
    }

    public List<String> userPermissionList(Person user) {
        RoleEntity rol = user.getRole();
        
        RolPerDTO rolPerDTO = modelMapper.map(rol, RolPerDTO.class);
        
        List<String> permissionList = rolPerDTO.getPermissions().stream()
                                                .map(PermissionDTO::getNombre)
                                                .collect(Collectors.toList());

        return permissionList;
    }


}
