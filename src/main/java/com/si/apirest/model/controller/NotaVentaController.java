package com.si.apirest.model.controller;

import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.dto.NotaVentaDTO;
import com.si.apirest.model.entity.NotaVenta;
import com.si.apirest.model.service.NotaVentaService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/venta")
@RequiredArgsConstructor
public class NotaVentaController {
    
    @Autowired
    private final NotaVentaService notaVentaService;

    @Autowired
    private final ModelMapper modelMapper;

    @PostMapping()
    public NotaVentaDTO createNotaVenta(@RequestBody NotaVentaDTO notaVenta) {
        NotaVenta nota = modelMapper.map(notaVenta, NotaVenta.class);
        return notaVentaService.createNotaVenta(nota);
    }

    @GetMapping()
    public List<NotaVentaDTO> getAllNotaVenta() {
        return notaVentaService.getAllNotaVenta();
    }

    @PutMapping("/{id}")
    public NotaVentaDTO updateNotaVenta(@RequestBody NotaVenta notaVenta) {
        return notaVentaService.updNotaVenta(notaVenta);
    }
    
    @GetMapping("/{id}")
    public NotaVentaDTO getNotaVenta(@PathVariable int id) {
        return notaVentaService.getNotaVenta(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNotaVenta(@PathVariable int id) {
        notaVentaService.deleteNotaVenta(id);
    }
    

}
