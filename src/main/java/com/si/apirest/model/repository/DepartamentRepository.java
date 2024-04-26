package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.si.apirest.model.entity.Departament;

public interface DepartamentRepository extends JpaRepository <Departament, Integer>{
    
}
