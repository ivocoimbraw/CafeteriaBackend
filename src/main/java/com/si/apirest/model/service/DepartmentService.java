package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.si.apirest.model.entity.Departament;
import com.si.apirest.model.repository.DepartamentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    
    @Autowired
    private final DepartamentRepository departamentRepository;

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
}
