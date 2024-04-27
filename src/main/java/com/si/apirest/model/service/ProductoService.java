package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public void crearProducto (Producto producto){
        productoRepository.save(producto);
    }    

    public Optional<Producto> findProducto (int id){
        return productoRepository.findById(id);
    }

    public List<Producto> getAllProducto(){
        return productoRepository.findAll();
    }

    public void deleteProducto(int id){
        productoRepository.deleteById(id);
    }

    public void updateProducto (Producto producto){
        productoRepository.save((producto));
    }
    
}
