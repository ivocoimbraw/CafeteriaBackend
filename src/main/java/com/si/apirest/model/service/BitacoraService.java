package com.si.apirest.model.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.BitacoraDTO;
import com.si.apirest.model.entity.Bitacora;
import com.si.apirest.model.repository.BitacoraRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BitacoraService {

    @Autowired
    private final BitacoraRepository bitacoraRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public Bitacora saveBitacora(BitacoraDTO bitacoraEntity){
        Bitacora bitacora = modelMapper.map(bitacoraEntity, Bitacora.class);
        return bitacoraRepository.save(bitacora);
    }

    public List<BitacoraDTO> findAllBitacora(){
        return bitacoraRepository.findAll().stream()
        .map(bitacora -> modelMapper.map(bitacora, BitacoraDTO.class) )
        .collect(Collectors.toList());
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
