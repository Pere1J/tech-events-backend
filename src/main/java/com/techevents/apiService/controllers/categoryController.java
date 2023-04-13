package com.techevents.apiService.controllers;


import com.techevents.domain.models.Category;
import com.techevents.domain.models.Event;
import com.techevents.infrastructure.repositories.ICategoryRepository;
import com.techevents.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categories")
public class categoryController {

    private final CategoryService categoryService;
    private final ICategoryRepository categoryRepository;
    public categoryController(CategoryService categoryService, ICategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(this.categoryService.findAll());
    }
}
