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

import com.si.apirest.model.entity.Proveedor;
import com.si.apirest.model.service.ProveedorService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proveedor")
public class ProveedorController {
    
    @Autowired
    private final ProveedorService proveedorService;

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.crearProveedor(proveedor);
    }

    @GetMapping("/{id}")
    public Proveedor getProveedor(@PathVariable int id) {
        return proveedorService.getProveedor(id);
    }

    @GetMapping
    public List<Proveedor> getAllProveedor() {
        return proveedorService.getAllProveedor();
    }

    @DeleteMapping("/{id}")
    public void deleteProveedor(@PathVariable int id) {
        proveedorService.deleteProveedor(id);
    }

    @PutMapping
    public Proveedor updateProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.updateProveedor(proveedor);
    }

}
