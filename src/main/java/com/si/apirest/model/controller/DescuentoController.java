package com.si.apirest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Descuento;
import com.si.apirest.model.service.DescuentoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/descuento")
public class DescuentoController {
    
    @Autowired
    private final DescuentoService descuentoService;

    @PostMapping
    public Descuento createDescuento(@RequestBody Descuento descuento) {
        return descuentoService.createDescuento(descuento);
    }

    @PutMapping
    public Descuento updateDescuento(@RequestBody Descuento descuento) {
        return descuentoService.updateDescuento(descuento);
    }

    @GetMapping("/{id}")
    public Descuento getDescuento(@PathVariable int id) {
        return descuentoService.getDescuento(id);
    }

    @GetMapping
    public List<Descuento> getAllDescuento() {
        return descuentoService.getAllDescuento();
    }

    @DeleteMapping("/{id}")
    public void deleteDescuento(@PathVariable int id) {
        descuentoService.deleteDescuento(id);
    }
    
}
