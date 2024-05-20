package com.si.apirest.model.service;


import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.BitacoraDTO;
import com.si.apirest.model.entity.Bitacora;
import com.si.apirest.model.entity.Person;
import com.si.apirest.model.repository.BitacoraRepository;
import com.si.apirest.model.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BitacoraService {

    @Autowired
    private final BitacoraRepository bitacoraRepository;

    @Autowired
    private final ModelMapper modelMapper;
    
    @Autowired
    private final PersonRepository personRepository;

    public BitacoraDTO saveBitacora(BitacoraDTO bitacoraEntity){
        Person user = personRepository.findById(bitacoraEntity.getUser().getId()).orElse(null);
        return modelMapper.map(bitacoraRepository.save(Bitacora.builder()
        .accion(bitacoraEntity.getAccion())
        .fecha(bitacoraEntity.getFecha())
        .user(user)
        .ip(bitacoraEntity.getIp())
        .build()), 
        BitacoraDTO.class);
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
