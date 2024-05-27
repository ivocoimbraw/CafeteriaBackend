package com.si.apirest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.service.InventarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventario")
public class InventarioController {
    
    @Autowired
    private final InventarioService inventarioService;

    @GetMapping("/{id}")
    public Inventario getInventario(@PathVariable int id) {
        return inventarioService.getInventario(id);
    }

    @GetMapping
    public List<Inventario> getAllInventario() {
        return inventarioService.getAllInventario();
    }

}
