package com.si.apirest.model.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Departament;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.DepartmentService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departament")
@Tag(name = "Departamento")
public class DepartamentController {
    
    @Autowired
    private final DepartmentService departamentService;
    
    @Operation(summary="guarda un departamento")
    @PostMapping("/save")
    public ResponseEntity<OkResponse> crearDepartament(@RequestBody @Valid Departament departament) {
        departamentService.createDepartament(departament);
        return ResponseEntity.ok(OkResponse.builder()
        .message("Creación de departamento correcta.")
        .build());
    }

    @PutMapping("/update")
    public void updateDepartament(@RequestBody Departament departament) {
        departamentService.updateDepartament(departament);
    }

    @GetMapping("/{id}")
    public Optional<Departament> getDepartament(@PathVariable int id) {
        return departamentService.getDepartament(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartament(@PathVariable int id) {
         departamentService.deleteDepartament(id);
    }

    @GetMapping
    public List<Departament> getAllDepartament() {
        return departamentService.getAllDepartament();
    }

}
