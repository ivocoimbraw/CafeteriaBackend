package com.si.apirest.model.controller;

import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Imagen;
import com.si.apirest.model.service.ImagenService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/imagen")
@RequiredArgsConstructor
public class ImagenController {
    @Autowired
    private final ImagenService imagenService;

    @GetMapping
    public List<Imagen> getImagenes() {
        return imagenService.getImagenes();
    }
    
    @PostMapping
    public Imagen createImagen(@RequestBody Imagen imagen) {
        return imagenService.crearImagen(imagen);
    }

    @PutMapping
    public Imagen updateImagen(@RequestBody Imagen imagen) {
        return imagenService.upadateImagen(imagen);
    }

    @DeleteMapping("/{id}")
    public void deleteImagen(@PathVariable int id) {
        imagenService.deleteImagen(id);
    }

}
