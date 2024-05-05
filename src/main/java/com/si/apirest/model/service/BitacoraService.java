package com.si.apirest.model.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Bitacora;
import com.si.apirest.model.repository.BitacoraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BitacoraService {
    private final BitacoraRepository bitacoraRepository;

    public Bitacora saveBitacora(Bitacora bitacoraEntity){
        return bitacoraRepository.save(bitacoraEntity);
    }

    public List<Bitacora> findAllBitacora(){
        return bitacoraRepository.findAll();
    }

    public Bitacora findBitacoraById(Integer id){
        return bitacoraRepository.findById(id).orElseThrow();
    }

    public void deleteBitacora(Integer id){
        bitacoraRepository.deleteById(id);
    }

    public Bitacora updateBitacora(Bitacora bitacoraEntity){
        return bitacoraRepository.save(bitacoraEntity);
    }
    
}
