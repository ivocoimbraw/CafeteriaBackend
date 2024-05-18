package com.si.apirest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.ProductoDTO;
import com.si.apirest.model.entity.Producto;
import com.si.apirest.model.repository.ProductoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductoService {

    @Autowired
    private final ProductoRepository productoRepository;

    @Autowired    
    private final ModelMapper modelMapper;

    public void crearProducto (Producto producto){
        productoRepository.save(producto);
    }    

    public Optional<Producto> findProducto (int id){
        return productoRepository.findById(id);
    }

    public List<ProductoDTO> getAllProducto(){
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        List<Producto> productos = productoRepository.findAll();
        for (Producto producto : productos) {
            productoDTOs.add(modelMapper.map(producto,ProductoDTO.class));
        }
        return productoDTOs;
    }

    public void deleteProducto(int id){
        productoRepository.deleteById(id);
    }

    public void updateProducto (Producto producto){
        productoRepository.save((producto));
    }
    
}
