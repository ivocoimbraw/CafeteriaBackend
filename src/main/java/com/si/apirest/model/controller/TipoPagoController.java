package com.si.apirest.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.TipoPago;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.TipoPagoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipopago")
public class TipoPagoController {
    
    @Autowired
    private final TipoPagoService tipoPagoService;

    @PostMapping("/save")
    public ResponseEntity<OkResponse> crearTipoPago(@RequestBody TipoPago tipoPago) {
        tipoPagoService.createTipoPago(tipoPago);
        return ResponseEntity.ok(OkResponse.builder()
        .message("Creación de TipoPago correcta.")
        .build());
    }

    @PutMapping("/update")
    public ResponseEntity<OkResponse> updateTipoPago(@RequestBody TipoPago tipoPago) {
        return tipoPagoService.updateTipoPago(tipoPago);
    }

    @GetMapping("/{id}")
    public Optional<TipoPago> getTipoPago(@PathVariable int id) {
        return tipoPagoService.getTipoPago(id);
    }

    @DeleteMapping("/{id}")
    public String deleteTipoPago(@PathVariable int id) {
        return tipoPagoService.deleteTipoPago(id);
    }

    @DeleteMapping("/delete-all")
    public String deleteAllTipoPago() {
        return tipoPagoService.deleteAllTipoPago();
    }


}
