package com.si.apirest.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.si.apirest.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
    
}
