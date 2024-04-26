package com.si.apirest.model.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.si.apirest.model.entity.Category;
import com.si.apirest.model.exceptions.OkResponse;
import com.si.apirest.model.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private final CategoryService categoryService;

     @PostMapping("/save")
    public ResponseEntity<OkResponse> crearCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return ResponseEntity.ok(OkResponse.builder()
        .message("Creación de categoria correcta.")
        .build());
    }

    @PutMapping("/update")
    public void updateDepartament(@RequestBody Category category) {
        categoryService.updateCategory(category);
    }

    @GetMapping("/{id}")
    public Optional<Category> getDepartament(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDepartament(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

}
