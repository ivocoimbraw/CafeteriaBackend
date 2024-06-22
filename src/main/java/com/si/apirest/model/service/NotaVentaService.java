package com.si.apirest.model.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.NotaVentaDTO;
import com.si.apirest.model.dto.ReportVentaDTO;
import com.si.apirest.model.entity.DetalleVenta;
import com.si.apirest.model.entity.NotaVenta;
import com.si.apirest.model.repository.NotaVentaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotaVentaService {

    @Autowired
    private final NotaVentaRepository notaVentaRepository;

    @Autowired
    private final ModelMapper modelMapper;

    @Transactional
    public NotaVentaDTO createNotaVenta(NotaVenta notaVenta) {

        for (DetalleVenta detalleVenta : notaVenta.getDetalleVenta()) {
            detalleVenta.setNotaVenta(notaVenta);
        }

        NotaVenta notaSaved =  notaVentaRepository.save(notaVenta);

        return modelMapper.map(notaSaved, NotaVentaDTO.class);
    }

    public NotaVentaDTO updNotaVenta(NotaVenta notaVenta) {
        Optional<NotaVenta> notaOptional = notaVentaRepository.findById(notaVenta.getId());
        if (notaOptional.isPresent()) {
            notaVenta.setStatus(notaOptional.get().getStatus());
            NotaVenta notaSaved = notaVentaRepository.save(notaVenta);
            return modelMapper.map(notaSaved, NotaVentaDTO.class);
        }else {
            throw new EntityNotFoundException("Nota no encontrada para actualizar");
        }
    }

    public NotaVentaDTO getNotaVenta(int id) {
        NotaVenta notaFinded = notaVentaRepository.findById(id).orElse(null);
        return modelMapper.map(notaFinded, NotaVentaDTO.class);
    }

    public List<NotaVentaDTO> getAllNotaVenta() {
        return notaVentaRepository.findAll()
        .stream()
        .map(notaVenta -> modelMapper.map(notaVenta, NotaVentaDTO.class))
        .collect(Collectors.toList());
    }

    public void deleteNotaVenta(int id) {
        notaVentaRepository.deleteById(id);
    }

    public List<ReportVentaDTO> findReporteVenta(int id) {
        return notaVentaRepository.findVentaReportData(id);
    }

    public BigDecimal findTotalVenta(int id) {
        return notaVentaRepository.findTotalVenta(id);
    }

}
