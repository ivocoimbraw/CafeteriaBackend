package com.si.apirest.model.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.RoleEntity;
import com.si.apirest.model.dto.RolPermissionDTO;
import com.si.apirest.model.entity.RolePermissionEntity;
import com.si.apirest.model.repository.RolPermissionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolPermissionService {

    @Autowired
    private final RolPermissionRepository rolPermissionRepository;

}
