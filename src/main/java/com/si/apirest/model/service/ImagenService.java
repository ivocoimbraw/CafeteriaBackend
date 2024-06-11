package com.si.apirest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Imagen;
import com.si.apirest.model.repository.ImagenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImagenService {

    @Autowired
    private final ImagenRepository imagenRepository;

    public List<Imagen> getImagenes() {
        return imagenRepository.findAll();
    }

    public Imagen crearImagen(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    public Imagen upadateImagen(Imagen imagen) {
        return imagenRepository.save((imagen));
    }

    public void deleteImagen(int id) {
        imagenRepository.deleteById(id);
    }

    public Imagen getImagen(int id) {
        return imagenRepository.findById(id).orElse(null);
    }


}
