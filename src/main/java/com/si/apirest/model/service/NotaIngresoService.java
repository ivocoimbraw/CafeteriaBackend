package com.si.apirest.model.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.NotaIngresoDTO;
import com.si.apirest.model.entity.DetalleIngreso;
import com.si.apirest.model.entity.NotaIngreso;
import com.si.apirest.model.repository.NotaIngresoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaIngresoService {
    
    @Autowired
    private final NotaIngresoRepository notaIngresoRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Transactional
    public NotaIngreso createNotaIngreso(NotaIngresoDTO notaIngresoDTO) {
        NotaIngreso notaIngreso = modelMapper.map(notaIngresoDTO, NotaIngreso.class);
        System.out.println(notaIngreso);
        for (DetalleIngreso detalleIngreso: notaIngreso.getDetalleIngreso()){
            detalleIngreso.setNotaIngreso(notaIngreso);
        }

        return notaIngresoRepository.save(notaIngreso);
    }

    public NotaIngreso getNotaIngreso(int id) {
        return notaIngresoRepository.findById(id).orElse(null);
    }

    public List<NotaIngreso> getAllNotaIngreso() {
        return notaIngresoRepository.findAll();
    }

    public void deleteNotaIngreso(int id) {
        notaIngresoRepository.deleteById(id);
    }

}
