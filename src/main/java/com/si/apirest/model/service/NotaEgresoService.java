package com.si.apirest.model.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.NotaEgresoDTO;
import com.si.apirest.model.entity.DetalleEgreso;
import com.si.apirest.model.entity.NotaEgreso;
import com.si.apirest.model.repository.NotaEgresoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaEgresoService {

    @Autowired
    private final NotaEgresoRepository notaEgresoRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Transactional
    public NotaEgreso createNotaEgreso(NotaEgresoDTO notaEgresoDTO) {
        NotaEgreso notaEgreso = modelMapper.map(notaEgresoDTO, NotaEgreso.class);
        List<DetalleEgreso> detalleEgresoList = notaEgreso.getDetalleEgreso();
        for (DetalleEgreso detalleEgreso : detalleEgresoList) {
            detalleEgreso.setNotaEgreso(notaEgreso);
        }

        return notaEgresoRepository.save(notaEgreso);
    }

    public NotaEgreso getNotaEgreso(int id) {
        return notaEgresoRepository.findById(id).orElse(null);
    }

    public List<NotaEgreso> getAllNotaEgreso() {
        return notaEgresoRepository.findAll();
    }

    public void deleteNotaEgreso(int id) {
        notaEgresoRepository.deleteById(id);
    }
}
