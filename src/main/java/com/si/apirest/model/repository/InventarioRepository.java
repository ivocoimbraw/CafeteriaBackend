package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.si.apirest.model.entity.Inventario;

@Repository
public interface InventarioRepository extends JpaRepository<Inventario, Integer>{
    
}
