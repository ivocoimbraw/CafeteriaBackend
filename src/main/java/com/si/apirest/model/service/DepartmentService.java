package com.si.apirest.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.dto.DepartmentDTO;
import com.si.apirest.model.entity.Departament;
import com.si.apirest.model.repository.DepartamentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    
    @Autowired
    private final DepartamentRepository departamentRepository;

    @Autowired
    private final ModelMapper modelMapper;

    public void createDepartament(Departament departament) {
        departamentRepository.save(departament);
    }

    public Departament updateDepartament(Departament departament) {
        return departamentRepository.save((departament));
    }

    public void deleteDepartament(int id) {
        departamentRepository.deleteById(id);
    }

    public Optional<Departament> getDepartament(int id) {
        return departamentRepository.findById(id);
    }

    public List<Departament> getAllDepartament() {
        return departamentRepository.findAll();
    }

    public List<DepartmentDTO> getAllDepartamentCat() {
        List<Departament> departments = departamentRepository.findAll();
        List<DepartmentDTO> departmentDTOs = new ArrayList<>();
        for (Departament departament : departments) {
            departmentDTOs.add(modelMapper.map(departament, DepartmentDTO.class));
        }
        
        return departmentDTOs;
    }

}
