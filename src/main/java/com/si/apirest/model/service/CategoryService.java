package com.si.apirest.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.si.apirest.model.entity.Category;
import com.si.apirest.model.repository.CategoryRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class CategoryService {
    
    @Autowired
    private final CategoryRepository categoryRepository;

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save((category));
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.findById(id);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
