package com.techevents.service;

import com.techevents.domain.models.Category;
import com.techevents.infrastructure.repositories.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll(){return this.categoryRepository.findAll();
    }

}
