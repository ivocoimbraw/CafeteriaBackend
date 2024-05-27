package com.si.apirest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Inventario;
import com.si.apirest.model.repository.InventarioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventarioService {
    
    @Autowired
    private final InventarioRepository inventarioRepository;

    public List<Inventario> getAllInventario() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventario(int id) {
        return inventarioRepository.findById(id).orElse(null);
    }

}
