package com.si.apirest.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.dto.NotaEgresoDTO;
import com.si.apirest.model.entity.NotaEgreso;
import com.si.apirest.model.service.NotaEgresoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nota-egreso")
public class NotaEgresoController {

    @Autowired
    private final NotaEgresoService notaEgresoService;

    @PostMapping
    public NotaEgreso createNotaEgreso(@RequestBody NotaEgresoDTO notaEgresoDTO) {
        return notaEgresoService.createNotaEgreso(notaEgresoDTO);
    }

    @GetMapping("/{id}")
    public NotaEgreso getNotaEgreso(@PathVariable int id) {
        return notaEgresoService.getNotaEgreso(id);
    }

    @GetMapping
    public List<NotaEgreso> getAllNotaEgreso() {
        return notaEgresoService.getAllNotaEgreso();
    }

    @DeleteMapping("/{id}")
    public void deleteNotaEgreso(@PathVariable int id) {
        notaEgresoService.deleteNotaEgreso(id);
    }

}
