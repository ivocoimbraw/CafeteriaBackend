package com.si.apirest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.PermissionEntity;
import com.si.apirest.model.service.PermissionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/permiso")
@RequiredArgsConstructor
public class PermissionController {
    
    @Autowired 
    private final PermissionService permissionService;
    
    @GetMapping("/{id}")
    public PermissionEntity gePermissionEntity(@PathVariable int id) {
        return permissionService.getPermiso(id);
    }   

    @GetMapping("/get-all")
    public List<PermissionEntity> getAllPermission() {
        return permissionService.getAllPermission();
    }

    @GetMapping("/list-permissions")
    public List<String> userPermissionList(@RequestParam String username) {
        return permissionService.userPermissionList(username);
    }

}
