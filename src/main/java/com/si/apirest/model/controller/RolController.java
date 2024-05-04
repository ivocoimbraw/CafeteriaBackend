package com.si.apirest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.RoleEntity;
import com.si.apirest.model.service.RolService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rol")
public class RolController {
    
    @Autowired
    private final RolService rolService;

    @PostMapping("/save")
    public RoleEntity crearRol(@RequestBody RoleEntity roleEntity) {
        return rolService.crearRol(roleEntity);
    }

    @PutMapping("/{id}")
    public RoleEntity updateRol(@PathVariable int id, @RequestBody RoleEntity roleEntity) {
        return rolService.updateRol(id, roleEntity);
    }   

    @GetMapping("/{id}")
    public RoleEntity getRol(@PathVariable int id) {
        return rolService.getRol(id);
    }

    @GetMapping("/get-all")
    public List<RoleEntity> getAllRol() {
        return rolService.getAllRol();
    }

    @DeleteMapping("/{id}")
    public void deleteRol(@PathVariable int id)  {
        rolService.deleteRol(id);
    }
}
