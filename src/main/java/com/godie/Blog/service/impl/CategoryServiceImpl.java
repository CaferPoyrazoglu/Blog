package com.godie.Blog.service.impl;

import com.godie.Blog.dto.Category.CategoryDto;
import com.godie.Blog.dto.Category.CreateCategoryRequestDto;
import com.godie.Blog.mapper.CategoryMapper;
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
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto createCategory(CreateCategoryRequestDto createCategoryRequestDto) {
        Category newCategory = categoryRepository.save(Category.builder().name(createCategoryRequestDto.getName()).build());
        return categoryMapper.toDto(newCategory);
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
    public List<CategoryDto> listCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryMapper.toDto(categoryList);
    }

}
