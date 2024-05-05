package com.si.apirest.model.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Bitacora;
import com.si.apirest.model.service.BitacoraService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bitacora")
public class BitacoraController {
    private final BitacoraService bitacoraService;

    @PostMapping
    public Bitacora saveBitacora(@RequestBody Bitacora bitacoraEntity){
        return bitacoraService.saveBitacora(bitacoraEntity);
    }

    @GetMapping("/get-all")
    public List<Bitacora> getAllBitacora(){
        return bitacoraService.findAllBitacora();
    }

}
