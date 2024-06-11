package com.si.apirest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Proveedor;
import com.si.apirest.model.repository.ProveedorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    
    @Autowired
    private final ProveedorRepository proveedorRepository;

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor getProveedor(int id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public List<Proveedor> getAllProveedor() {
        return proveedorRepository.findAll();
    }

    public void deleteProveedor(int id) {
        proveedorRepository.deleteById(id);
    }

    public Proveedor updateProveedor(Proveedor proveedor) {
        return proveedorRepository.save((proveedor));
    }

}
