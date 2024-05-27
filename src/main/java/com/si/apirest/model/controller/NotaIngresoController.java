package com.si.apirest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.dto.NotaIngresoDTO;
import com.si.apirest.model.entity.NotaIngreso;
import com.si.apirest.model.service.NotaIngresoService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nota-ingreso")
public class NotaIngresoController {
    
    @Autowired
    private final NotaIngresoService notaIngresoService;

    @PostMapping
    public NotaIngreso createNotaIngreso(@RequestBody NotaIngresoDTO notaIngreso) {
        return notaIngresoService.createNotaIngreso(notaIngreso);
    }

    @GetMapping("/{id}")
    public NotaIngreso getNotaIngreso(@PathVariable int id) {
        return notaIngresoService.getNotaIngreso(id);
    }

    @GetMapping
    public List<NotaIngreso> getAllNotaIngreso() {
        return notaIngresoService.getAllNotaIngreso();
    }

    @DeleteMapping("/{id}")
    public void deleteNotaIngreso(@PathVariable int id) {
        notaIngresoService.deleteNotaIngreso(id);
    }

}
