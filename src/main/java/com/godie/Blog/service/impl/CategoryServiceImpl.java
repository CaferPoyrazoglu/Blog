package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
import com.godie.Blog.model.Category;
import com.godie.Blog.repository.CategoryRepository;
import com.godie.Blog.service.CategoryService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        return categoryRepository.save(Category.builder().name(createCategoryRequestDto.getName()).build());
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id" + categoryId));
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

}
