package com.si.apirest.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Descuento;
import com.si.apirest.model.exceptions.NotFoundException;
import com.si.apirest.model.repository.DescuentoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DescuentoService {
    
    @Autowired
    private final DescuentoRepository descuentoRepository;

    public Descuento createDescuento(Descuento descuento) {
        return descuentoRepository.save(descuento);
    }   

    public Descuento updateDescuento(Descuento descuento) {
        return descuentoRepository.save(descuento);
    }

    public Descuento getDescuento(int id) {
        Descuento descuento = descuentoRepository.findById(id)
                            .orElseThrow(() -> 
                                new NotFoundException("Descuento no encontrado.")
                            );
        return descuento;
    }

    public void deleteDescuento(int id) {
        descuentoRepository.deleteById(id);
    }

    public List<Descuento> getAllDescuento() {
        return descuentoRepository.findAll();
    }


}
